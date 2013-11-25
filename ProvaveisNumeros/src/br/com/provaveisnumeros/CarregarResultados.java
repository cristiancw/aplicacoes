package br.com.provaveisnumeros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.text.html.parser.ParserDelegator;

import br.com.Resultado;

/**
 * Faz o download do arquivo do site da caixa, descompacta o arquivo e faz o parser do arquivo html para uma lista de objetos {@link Resultado}.
 * 
 * @author Cristiancw
 * 
 */
class CarregarResultados {

	private static final String SITE = "http://www1.caixa.gov.br/loterias/_arquivos/loterias/";
	private static final String FILE = "D_megase.zip";
	private static final String FILE_IN_ZIP = "D_MEGA.HTM";
	private static final int TIMEOUT = 1000 * 60;

	private final String ZIP_FILE;
	private final String HTML_FILE;

	/**
	 * Define o caminho padrão para os aquivos que vai baixar e carregar os concursos. O caminho padrão é o que esta definido na propriedade <code>user.dir</code>. O nome do arquivo compactado que vai
	 * buscar é fixo com D_megase.zip e do descompactado é fixo com D_MEGA.HTM.
	 */
	CarregarResultados() {
		String caminho = System.getProperty("user.dir");
		ZIP_FILE = caminho + "\\" + FILE;
		HTML_FILE = caminho + "\\" + FILE_IN_ZIP;
	}

	/**
	 * Permite o usuário definir o caminho além do padrão, porém o nome dos arquivos compactados e descompactados continua fixo em: D_megase.zip e D_MEGA.HTM.
	 * 
	 * @param caminho
	 */
	CarregarResultados(String caminho) {
		ZIP_FILE = caminho + "\\" + FILE;
		HTML_FILE = caminho + "\\" + FILE_IN_ZIP;
	}

	/**
	 * Baixa um arquivo diretamente do site da caixa com a lista de todos os restultados mega sena e descompacta o resultado. Sempre mantém o último arquivo baixado e o último resultado descompactado.
	 * 
	 * @throws IOException
	 *             pode ocorrer erro ao tentar conectar no site ou ao tentar criar o arquivo zipado no caminho da maquina.
	 */
	void baixar() throws IOException {
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

		// Configura conexão para baixar
		URL url = new URL(SITE + FILE);
		URLConnection conn = url.openConnection();
		conn.setReadTimeout(TIMEOUT);
		conn.setConnectTimeout(TIMEOUT);
		conn.setUseCaches(true);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("content-type", "binary/data");

		// Define caminho do arquivo compactado para baixar localmente
		InputStream in = conn.getInputStream();
		FileOutputStream out = new FileOutputStream(ZIP_FILE);
		try {
			byte[] b = new byte[1024];
			int count = 0;

			// Copia o arquivo do site para caminho local
			while ((count = in.read(b)) > 0) {
				out.write(b, 0, count);
			}

			// Descompata o html com o resultado
			ZipInputStream zin = new ZipInputStream(new FileInputStream(ZIP_FILE));
			try {
				ZipEntry zipElement = zin.getNextEntry();
				while (zipElement != null) {
					if (FILE_IN_ZIP.equals(zipElement.getName())) {
						FileOutputStream outZip = new FileOutputStream(HTML_FILE);
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
	 * Lê o arquivo que foi baixado do site da caixa e transforma cada linha de resultado em um objeto {@link Resultado}.
	 * 
	 * @return uma lista de objetos {@link Resultado}
	 * @throws IOException
	 */
	List<Resultado> carregarResultado() throws IOException {
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();

		Reader reader = new FileReader(HTML_FILE);
		ParserDelegator parser = new ParserDelegator();
		DMegaParserCallBack callback = new DMegaParserCallBack();
		parser.parse(reader, callback, false);
		resultados.addAll(callback.getResultados());

		return resultados;
	}
}
