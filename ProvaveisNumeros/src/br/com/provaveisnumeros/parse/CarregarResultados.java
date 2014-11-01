package br.com.provaveisnumeros.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import br.com.Resultado;

/**
 * Faz o download do arquivo do site da caixa, descompacta o arquivo e faz o parser do arquivo html para uma lista de objetos {@link Resultado}.
 * 
 * @author Cristiancw
 * 
 */
public class CarregarResultados {

	public static final String ZIP_FILE = "D_megase.zip";
	public static final String HTML_FILE = "D_MEGA.HTM";
	public static final String CACHE_FILE = "cache.dat";

	private final File htmlFile;
	private final InputStream htmlFileInAssets;
	private final File cacheDir;

	private static final String SITE = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/";
	private static final int TIMEOUT = 1000 * 60;

	public CarregarResultados(File htmlFile, InputStream htmlFileInAssets, File cacheDir) {
		this.htmlFile = htmlFile;
		this.htmlFileInAssets = htmlFileInAssets;
		this.cacheDir = cacheDir;
	}

	/**
	 * Verifica se o arquivo com os resultados já foi carregado alguma vez. Quando for a primeira execução da aplicação, normalmente ele não vai estar carregado ainda e quando ocorrer uma falha ao
	 * baixar o arquivo novo.
	 * 
	 * @return true se já foi criado alguma vez o arquivo
	 */
	public boolean isIniciado() {
		return htmlFile.exists() && htmlFile.length() > 0;
	}

	/**
	 * Quando for executado pela primeira vez, o arquivos com os historicos dos resultados vai estar empacotado dentro da app. A UI fornece o caminho dos arquivos internos e um caminho externo, para
	 * copiar o arquivo de dentro da app para um caminho fora da app, permitindo a app ler e alterar esse arquivo.
	 * 
	 * @param htmlFile
	 * @param htmlFileInAssets
	 * @throws IOException
	 */
	public void copiarArquivoHtml() throws IOException {
		FileOutputStream out = new FileOutputStream(htmlFile);
		try {
			byte[] b = new byte[1024];
			int count = 0;

			// Copia o arquivo do site para caminho local
			while ((count = htmlFileInAssets.read(b)) > 0) {
				out.write(b, 0, count);
			}
		} finally {
			out.close();
			htmlFileInAssets.close();
		}
	}

	/**
	 * Baixa um arquivo diretamente do site da caixa com a lista de todos os restultados mega sena e descompacta o resultado. Sempre mantém o último arquivo baixado e o último resultado descompactado.
	 * 
	 * @param zipFile
	 * @param htmlFile
	 * 
	 * @throws IOException
	 *             pode ocorrer erro ao tentar conectar no site ou ao tentar criar o arquivo zipado no caminho da maquina.
	 */
	public void baixar(File zipFile) throws IOException {
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

		// Configura conexão para baixar
		URL url = new URL(SITE + ZIP_FILE);
		URLConnection conn = url.openConnection();
		conn.setReadTimeout(TIMEOUT);
		conn.setConnectTimeout(TIMEOUT);
		conn.setUseCaches(true);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("content-type", "binary/data");

		// Define caminho do arquivo compactado para baixar localmente
		InputStream in = conn.getInputStream();
		FileOutputStream out = new FileOutputStream(zipFile);
		try {
			byte[] b = new byte[1024];
			int count = 0;

			// Copia o arquivo do site para caminho local
			while ((count = in.read(b)) > 0) {
				out.write(b, 0, count);
			}

			// Descompata o html com o resultado
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFile));
			try {
				ZipEntry zipElement = zin.getNextEntry();
				while (zipElement != null) {
					if (HTML_FILE.equals(zipElement.getName())) {
						FileOutputStream outZip = new FileOutputStream(htmlFile);
						try {
							// Copia o arquivo de dentro do zip
							count = 0;
							while ((count = zin.read(b)) > 0) {
								outZip.write(b, 0, count);
							}
						} finally {
							outZip.close();
						}
					}
					zin.closeEntry();
					zipElement = zin.getNextEntry();
				}
			} finally {
				zin.close();
			}
		} finally {
			out.close();
			in.close();
		}
	}

	/**
	 * Lê o arquivo passado que deve ser o mesmo carregado previamente pelo {@link #baixar(File, File)} e transforma cada linha de resultado em um objeto {@link Resultado}.
	 * 
	 * @param htmlFile
	 * 
	 * @return uma lista de objetos {@link Resultado}
	 * 
	 * @throws IOException
	 */
	public List<Resultado> carregarResultado() throws IOException {
		return DMegaParser.getResultados(htmlFile);
	}

	/**
	 * Verifica se já houve serialização da lista de resultados, para apenas carregar evitando fazer o parser mais de uma vez por troca de arquivo html com os resultados.
	 * 
	 * @param cacheDir
	 * @return <code>true</code> se existe cache
	 */
	public boolean isCached() {
		return getCacheFile(cacheDir);
	}

	/**
	 * Cria o arquivo de cache "cache.dat" com a lista de resultados carregada.
	 * 
	 * @param cacheDir
	 * @param resultados
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void criarCache(List<Resultado> resultados) throws IOException, ClassNotFoundException {
		File file = new File(cacheDir.getPath() + "/" + CACHE_FILE);
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		try {
			objOut.writeObject(resultados);
		} finally {
			objOut.close();
			out.close();
		}
	}

	/**
	 * Lê o diretorio passado, que deve vir do cache do android com o arquivo "cache.dat" pronto para ser lido. Esse arquivo deve conter a lista de resultados baixada anteriormente.
	 * 
	 * @param cacheDir
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<Resultado> carregarCache() throws IOException, ClassNotFoundException {
		File file = new File(cacheDir.getPath() + "/" + CACHE_FILE);
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream objIn = new ObjectInputStream(in);
		try {
			Object object = objIn.readObject();
			if (object instanceof List<?>) {
				return (List<Resultado>) object;
			}
		} finally {
			objIn.close();
			in.close();
		}
		return null;
	}

	private static boolean getCacheFile(File cacheDir) {
		File[] list = cacheDir.listFiles();
		for (File arquivo : list) {
			if (CACHE_FILE.equals(arquivo.getName()) && arquivo.exists() && arquivo.length() > 0) {
				return true;
			}
		}
		return false;
	}
}
