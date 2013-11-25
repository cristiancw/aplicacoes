package br.com.provaveisnumeros;

import java.io.File;
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
		final String caminho = System.getProperty("user.dir") + "//";

		// Garante que não tem os arquivos
		final String arquivoZip = "D_megase.zip";
		File fileZip = new File(caminho + arquivoZip);
		if (fileZip.exists()) {
			fileZip.delete();
		}
		Assert.assertFalse(fileZip.exists());

		final String arquivoHtml = "D_MEGA.HTM";
		File fileHtml = new File(caminho + arquivoHtml);
		if (fileHtml.exists()) {
			fileHtml.delete();
		}
		Assert.assertFalse(fileHtml.exists());

		CarregarResultados carregarResultados = new CarregarResultados();
		try {
			carregarResultados.baixar();
		} catch (IOException e) {
			Assert.fail("Erro ao baixar o arquivo");
		}

		// Valida que baixou o arquivo
		Assert.assertTrue(fileZip.exists());
		Assert.assertTrue(fileHtml.exists());
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
			CarregarResultados carregarResultados = new CarregarResultados("C:/Eclipse/workspace/ProvaveisNumeros/srcTest");
			carregarResultado = carregarResultados.carregarResultado();
		}
		return carregarResultado;
	}
}
