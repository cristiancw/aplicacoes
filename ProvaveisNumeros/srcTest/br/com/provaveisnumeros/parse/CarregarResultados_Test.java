package br.com.provaveisnumeros.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.Resultado;

public class CarregarResultados_Test {

	private List<Resultado> carregarResultado;

	@Test
	public void testaDownloadArquivo() {
		final String caminho = System.getProperty("user.dir") + "\\bin\\";

		// Garante que não tem os arquivos
		File zipFile = new File(caminho + CarregarResultados.ZIP_FILE);
		if (zipFile.exists()) {
			zipFile.delete();
		}
		Assert.assertFalse(zipFile.exists());

		File htmlFile = new File(caminho + CarregarResultados.HTML_FILE);
		if (htmlFile.exists()) {
			htmlFile.delete();
		}
		Assert.assertFalse(htmlFile.exists());

		try {
			CarregarResultados carregarResultados = new CarregarResultados(htmlFile, null, null);
			carregarResultados.baixar(zipFile);
		} catch (IOException e) {
			Assert.fail("Erro ao baixar o arquivo");
		}

		// Valida que baixou o arquivo
		Assert.assertTrue(zipFile.exists());
		Assert.assertTrue(htmlFile.exists());
	}

	@Test
	public void testaDownloadArquivoComLeitura() throws IOException {
		final String caminho = System.getProperty("user.dir") + "\\bin\\";

		// Garante que não tem os arquivos
		File zipFile = new File(caminho + CarregarResultados.ZIP_FILE);
		if (zipFile.exists()) {
			zipFile.delete();
		}
		Assert.assertFalse(zipFile.exists());

		File htmlFile = new File(caminho + CarregarResultados.HTML_FILE);
		if (htmlFile.exists()) {
			htmlFile.delete();
		}
		Assert.assertFalse(htmlFile.exists());

		CarregarResultados carregarResultados = new CarregarResultados(htmlFile, null, null);
		try {
			carregarResultados.baixar(zipFile);
		} catch (IOException e) {
			Assert.fail("Erro ao baixar o arquivo");
		}

		// Valida que baixou o arquivo
		Assert.assertTrue(zipFile.exists());
		Assert.assertTrue(htmlFile.exists());

		List<Resultado> resultados = carregarResultados.carregarResultado();
		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1996, 3, 11), concurso.getData());
		Assert.assertEquals(41, concurso.getPri_dezena());
		Assert.assertEquals(5, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(52, concurso.getQua_dezena());
		Assert.assertEquals(30, concurso.getQui_dezena());
		Assert.assertEquals(33, concurso.getSex_dezena());

		// avalia os numeros dos concursos
		int numero = 0;
		for (Resultado resultado : resultados) {
			numero++;
			Assert.assertEquals(numero, resultado.getNumero());
		}
		Assert.assertEquals(numero, resultados.size());
	}

	@Test
	public void testaCopiarArquivoHtml() {
		final String caminho = System.getProperty("user.dir") + "\\srcTest\\";

		File htmlFile = new File(caminho + CarregarResultados.HTML_FILE);
		Assert.assertTrue(htmlFile.exists());

		File copyFile = new File(caminho + "br\\" + CarregarResultados.HTML_FILE);
		if (copyFile.exists()) {
			copyFile.delete();
		}
		Assert.assertFalse(copyFile.exists());

		try {
			CarregarResultados carregarResultados = new CarregarResultados(copyFile, new FileInputStream(htmlFile), null);
			carregarResultados.copiarArquivoHtml();
		} catch (IOException e) {
			Assert.fail("Erro ao copiar o arquivo");
		}

		// Valida que copiou o arquivo
		Assert.assertTrue(htmlFile.exists());
		Assert.assertTrue(copyFile.exists());
		copyFile.delete();
	}

	@Test
	public void testaCarregaResultados_01() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1996, 3, 11), concurso.getData());
		Assert.assertEquals(41, concurso.getPri_dezena());
		Assert.assertEquals(5, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(52, concurso.getQua_dezena());
		Assert.assertEquals(30, concurso.getQui_dezena());
		Assert.assertEquals(33, concurso.getSex_dezena());
	}

	@Test
	public void testaCarregaResultados_02() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(43);
		Assert.assertEquals(44, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1997, 1, 5), concurso.getData());
		Assert.assertEquals(47, concurso.getPri_dezena());
		Assert.assertEquals(38, concurso.getSeg_dezena());
		Assert.assertEquals(18, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(29, concurso.getQui_dezena());
		Assert.assertEquals(44, concurso.getSex_dezena());
	}

	@Test
	public void testaCarregaResultados_03() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(99);
		Assert.assertEquals(100, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1998, 2, 1), concurso.getData());
		Assert.assertEquals(46, concurso.getPri_dezena());
		Assert.assertEquals(48, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(29, concurso.getQui_dezena());
		Assert.assertEquals(51, concurso.getSex_dezena());
	}

	@Test
	public void testaCarregaResultados_04() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(249);
		Assert.assertEquals(250, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2000, 12, 16), concurso.getData());
		Assert.assertEquals(55, concurso.getPri_dezena());
		Assert.assertEquals(25, concurso.getSeg_dezena());
		Assert.assertEquals(41, concurso.getTer_dezena());
		Assert.assertEquals(42, concurso.getQua_dezena());
		Assert.assertEquals(43, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());
	}

	@Test
	public void testaCarregaResultados_05() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(499);
		Assert.assertEquals(500, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2003, 9, 27), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(21, concurso.getSeg_dezena());
		Assert.assertEquals(54, concurso.getTer_dezena());
		Assert.assertEquals(29, concurso.getQua_dezena());
		Assert.assertEquals(38, concurso.getQui_dezena());
		Assert.assertEquals(36, concurso.getSex_dezena());
	}

	@Test
	public void testaCarregaResultados_06() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(999);
		Assert.assertEquals(1000, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2008, 8, 30), concurso.getData());
		Assert.assertEquals(49, concurso.getPri_dezena());
		Assert.assertEquals(58, concurso.getSeg_dezena());
		Assert.assertEquals(53, concurso.getTer_dezena());
		Assert.assertEquals(39, concurso.getQua_dezena());
		Assert.assertEquals(38, concurso.getQui_dezena());
		Assert.assertEquals(29, concurso.getSex_dezena());
	}

	@Test
	public void testaCarregaResultados_07() throws IOException {
		List<Resultado> resultados = getResultados();

		Resultado concurso = resultados.get(1537);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	private List<Resultado> getResultados() throws IOException {
		if (carregarResultado == null) {
			File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
			carregarResultado = new CarregarResultados(htmlFile, null, null).carregarResultado();
		}
		return carregarResultado;
	}
}
