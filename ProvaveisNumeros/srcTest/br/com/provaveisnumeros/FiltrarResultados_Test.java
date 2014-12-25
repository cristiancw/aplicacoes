package br.com.provaveisnumeros;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.Resultado;
import br.com.provaveisnumeros.parse.CarregarResultados;

public class FiltrarResultados_Test {

	private List<Resultado> carregarResultado;

	@Test
	public void testaListaAnos() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Integer> listaAnos = filtrarResultados.getListaAnos();
		Assert.assertEquals(18, listaAnos.size());
		Assert.assertEquals(2013, listaAnos.get(0).intValue());
		Assert.assertEquals(2012, listaAnos.get(1).intValue());
		Assert.assertEquals(2011, listaAnos.get(2).intValue());
		Assert.assertEquals(2010, listaAnos.get(3).intValue());
		Assert.assertEquals(2009, listaAnos.get(4).intValue());
		Assert.assertEquals(2008, listaAnos.get(5).intValue());
		Assert.assertEquals(2007, listaAnos.get(6).intValue());
		Assert.assertEquals(2006, listaAnos.get(7).intValue());
		Assert.assertEquals(2005, listaAnos.get(8).intValue());
		Assert.assertEquals(2004, listaAnos.get(9).intValue());
		Assert.assertEquals(2003, listaAnos.get(10).intValue());
		Assert.assertEquals(2002, listaAnos.get(11).intValue());
		Assert.assertEquals(2001, listaAnos.get(12).intValue());
		Assert.assertEquals(2000, listaAnos.get(13).intValue());
		Assert.assertEquals(1999, listaAnos.get(14).intValue());
		Assert.assertEquals(1998, listaAnos.get(15).intValue());
		Assert.assertEquals(1997, listaAnos.get(16).intValue());
		Assert.assertEquals(1996, listaAnos.get(17).intValue());
	}

	@Test
	public void testaResultados() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados();
		Assert.assertEquals(1538, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1996, 3, 11), concurso.getData());
		Assert.assertEquals(41, concurso.getPri_dezena());
		Assert.assertEquals(5, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(52, concurso.getQua_dezena());
		Assert.assertEquals(30, concurso.getQui_dezena());
		Assert.assertEquals(33, concurso.getSex_dezena());

		concurso = resultados.get(43);
		Assert.assertEquals(44, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1997, 1, 5), concurso.getData());
		Assert.assertEquals(47, concurso.getPri_dezena());
		Assert.assertEquals(38, concurso.getSeg_dezena());
		Assert.assertEquals(18, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(29, concurso.getQui_dezena());
		Assert.assertEquals(44, concurso.getSex_dezena());

		concurso = resultados.get(999);
		Assert.assertEquals(1000, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2008, 8, 30), concurso.getData());
		Assert.assertEquals(49, concurso.getPri_dezena());
		Assert.assertEquals(58, concurso.getSeg_dezena());
		Assert.assertEquals(53, concurso.getTer_dezena());
		Assert.assertEquals(39, concurso.getQua_dezena());
		Assert.assertEquals(38, concurso.getQui_dezena());
		Assert.assertEquals(29, concurso.getSex_dezena());

		concurso = resultados.get(1537);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadosAno_1996() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(1996);
		Assert.assertEquals(43, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1996, 3, 11), concurso.getData());
		Assert.assertEquals(41, concurso.getPri_dezena());
		Assert.assertEquals(5, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(52, concurso.getQua_dezena());
		Assert.assertEquals(30, concurso.getQui_dezena());
		Assert.assertEquals(33, concurso.getSex_dezena());

		concurso = resultados.get(21);
		Assert.assertEquals(22, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1996, 8, 5), concurso.getData());
		Assert.assertEquals(9, concurso.getPri_dezena());
		Assert.assertEquals(38, concurso.getSeg_dezena());
		Assert.assertEquals(56, concurso.getTer_dezena());
		Assert.assertEquals(1, concurso.getQua_dezena());
		Assert.assertEquals(31, concurso.getQui_dezena());
		Assert.assertEquals(46, concurso.getSex_dezena());

		concurso = resultados.get(42);
		Assert.assertEquals(43, concurso.getNumero());
		Assert.assertEquals(new LocalDate(1996, 12, 29), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(58, concurso.getSeg_dezena());
		Assert.assertEquals(25, concurso.getTer_dezena());
		Assert.assertEquals(6, concurso.getQua_dezena());
		Assert.assertEquals(26, concurso.getQui_dezena());
		Assert.assertEquals(17, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadosAno_2004() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(2004);
		Assert.assertEquals(102, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(526, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2004, 1, 3), concurso.getData());
		Assert.assertEquals(3, concurso.getPri_dezena());
		Assert.assertEquals(59, concurso.getSeg_dezena());
		Assert.assertEquals(21, concurso.getTer_dezena());
		Assert.assertEquals(36, concurso.getQua_dezena());
		Assert.assertEquals(55, concurso.getQui_dezena());
		Assert.assertEquals(31, concurso.getSex_dezena());

		concurso = resultados.get(51);
		Assert.assertEquals(577, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2004, 7, 3), concurso.getData());
		Assert.assertEquals(31, concurso.getPri_dezena());
		Assert.assertEquals(47, concurso.getSeg_dezena());
		Assert.assertEquals(28, concurso.getTer_dezena());
		Assert.assertEquals(23, concurso.getQua_dezena());
		Assert.assertEquals(8, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(101);
		Assert.assertEquals(627, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2004, 12, 29), concurso.getData());
		Assert.assertEquals(19, concurso.getPri_dezena());
		Assert.assertEquals(13, concurso.getSeg_dezena());
		Assert.assertEquals(45, concurso.getTer_dezena());
		Assert.assertEquals(58, concurso.getQua_dezena());
		Assert.assertEquals(56, concurso.getQui_dezena());
		Assert.assertEquals(1, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadosAno_2013() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(2013);
		Assert.assertEquals(83, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1456, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 1, 2), concurso.getData());
		Assert.assertEquals(36, concurso.getPri_dezena());
		Assert.assertEquals(6, concurso.getSeg_dezena());
		Assert.assertEquals(40, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(8, concurso.getQui_dezena());
		Assert.assertEquals(26, concurso.getSex_dezena());

		concurso = resultados.get(41);
		Assert.assertEquals(1497, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 5, 25), concurso.getData());
		Assert.assertEquals(58, concurso.getPri_dezena());
		Assert.assertEquals(7, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(45, concurso.getQua_dezena());
		Assert.assertEquals(4, concurso.getQui_dezena());
		Assert.assertEquals(5, concurso.getSex_dezena());

		concurso = resultados.get(82);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaHasResultado_01() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Assert.assertTrue(filtrarResultados.hasSorteio(new LocalDate(1996, 3, 11)));
	}

	@Test
	public void testaHasResultado_02() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Assert.assertFalse(filtrarResultados.hasSorteio(new LocalDate(1996, 3, 10)));
	}

	@Test
	public void testaHasResultado_03() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Assert.assertTrue(filtrarResultados.hasSorteio(new LocalDate(2003, 1, 8)));
	}

	@Test
	public void testaHasResultado_04() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Assert.assertFalse(filtrarResultados.hasSorteio(new LocalDate(2008, 3, 25)));
	}

	@Test
	public void testaHasResultado_05() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Assert.assertTrue(filtrarResultados.hasSorteio(new LocalDate(2013, 10, 11)));
	}

	@Test
	public void testaHasResultado_06() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Assert.assertFalse(filtrarResultados.hasSorteio(new LocalDate(2013, 10, 12)));
	}

	@Test
	public void testaBuscaDataAnterior_01() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Resultado concurso = filtrarResultados.buscaDataAnterior(new LocalDate(1996, 3, 11));

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
	public void testaBuscaDataAnterior_02() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		try {
			filtrarResultados.buscaDataAnterior(new LocalDate(1996, 3, 10));
			Assert.fail("Deveria ter lançando InvalidParameterException");
		} catch (InvalidParameterException e) {
			Assert.assertEquals("A data é menor que a data do primeiro concurso realizado. Dia: 10/03/1996", e.getMessage());
		} catch (Exception e) {
			Assert.fail("Deveria ter lançando InvalidParameterException");
		}
	}

	@Test
	public void testaBuscaDataAnterior_03() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Resultado concurso = filtrarResultados.buscaDataAnterior(new LocalDate(2011, 5, 7));

		Assert.assertEquals(1281, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2011, 5, 7), concurso.getData());
		Assert.assertEquals(36, concurso.getPri_dezena());
		Assert.assertEquals(14, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(38, concurso.getQua_dezena());
		Assert.assertEquals(11, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());
	}

	@Test
	public void testaBuscaDataAnterior_04() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Resultado concurso = filtrarResultados.buscaDataAnterior(new LocalDate(2011, 5, 9));

		Assert.assertEquals(1281, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2011, 5, 7), concurso.getData());
		Assert.assertEquals(36, concurso.getPri_dezena());
		Assert.assertEquals(14, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(38, concurso.getQua_dezena());
		Assert.assertEquals(11, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());
	}

	@Test
	public void testaBuscaDataPosterior_01() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Resultado concurso = filtrarResultados.buscaDataPosterior(new LocalDate(2013, 10, 11));

		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaBuscaDataPosterior_02() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		try {
			filtrarResultados.buscaDataPosterior(new LocalDate(2013, 10, 12));
			Assert.fail("Deveria ter lançando InvalidParameterException");
		} catch (InvalidParameterException e) {
			Assert.assertEquals("A data é maior que a data do último concurso realizado. Dia: 12/10/2013", e.getMessage());
		} catch (Exception e) {
			Assert.fail("Deveria ter lançando InvalidParameterException");
		}
	}

	@Test
	public void testaBuscaDataPosterior_03() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Resultado concurso = filtrarResultados.buscaDataPosterior(new LocalDate(2011, 5, 7));

		Assert.assertEquals(1281, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2011, 5, 7), concurso.getData());
		Assert.assertEquals(36, concurso.getPri_dezena());
		Assert.assertEquals(14, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(38, concurso.getQua_dezena());
		Assert.assertEquals(11, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());
	}

	@Test
	public void testaBuscaDataPosterior_04() throws IOException {
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		Resultado concurso = filtrarResultados.buscaDataPosterior(new LocalDate(2011, 5, 9));

		Assert.assertEquals(1282, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2011, 5, 11), concurso.getData());
		Assert.assertEquals(4, concurso.getPri_dezena());
		Assert.assertEquals(39, concurso.getSeg_dezena());
		Assert.assertEquals(56, concurso.getTer_dezena());
		Assert.assertEquals(23, concurso.getQua_dezena());
		Assert.assertEquals(52, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoData_01() throws IOException {
		LocalDate inicio = new LocalDate(1996, 3, 11);
		LocalDate fim = new LocalDate(1996, 3, 11);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

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
	public void testaResultadoData_02() throws IOException {
		LocalDate inicio = new LocalDate(1996, 3, 10);
		LocalDate fim = new LocalDate(1996, 3, 10);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(0, resultados.size());
	}

	@Test
	public void testaResultadoData_03() throws IOException {
		LocalDate inicio = new LocalDate(1996, 3, 11);
		LocalDate fim = new LocalDate(1996, 3, 12);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

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
	public void testaResultadoData_04() throws IOException {
		LocalDate inicio = new LocalDate(1996, 3, 10);
		LocalDate fim = new LocalDate(1996, 3, 11);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

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
	public void testaResultadoData_05() throws IOException {
		LocalDate inicio = new LocalDate(2013, 10, 11);
		LocalDate fim = new LocalDate(2013, 10, 11);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoData_06() throws IOException {
		LocalDate inicio = new LocalDate(2013, 10, 12);
		LocalDate fim = new LocalDate(2013, 10, 12);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(0, resultados.size());
	}

	@Test
	public void testaResultadoData_07() throws IOException {
		LocalDate inicio = new LocalDate(2013, 10, 11);
		LocalDate fim = new LocalDate(2013, 10, 12);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoData_08() throws IOException {
		LocalDate inicio = new LocalDate(2013, 10, 10);
		LocalDate fim = new LocalDate(2013, 10, 11);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoData_09() throws IOException {
		LocalDate inicio = new LocalDate(2005, 6, 4);
		LocalDate fim = new LocalDate(2005, 7, 6);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(10, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(670, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 4), concurso.getData());
		Assert.assertEquals(42, concurso.getPri_dezena());
		Assert.assertEquals(59, concurso.getSeg_dezena());
		Assert.assertEquals(58, concurso.getTer_dezena());
		Assert.assertEquals(37, concurso.getQua_dezena());
		Assert.assertEquals(48, concurso.getQui_dezena());
		Assert.assertEquals(22, concurso.getSex_dezena());

		concurso = resultados.get(1);
		Assert.assertEquals(671, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 8), concurso.getData());
		Assert.assertEquals(27, concurso.getPri_dezena());
		Assert.assertEquals(16, concurso.getSeg_dezena());
		Assert.assertEquals(39, concurso.getTer_dezena());
		Assert.assertEquals(51, concurso.getQua_dezena());
		Assert.assertEquals(9, concurso.getQui_dezena());
		Assert.assertEquals(38, concurso.getSex_dezena());

		concurso = resultados.get(2);
		Assert.assertEquals(672, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 11), concurso.getData());
		Assert.assertEquals(43, concurso.getPri_dezena());
		Assert.assertEquals(34, concurso.getSeg_dezena());
		Assert.assertEquals(53, concurso.getTer_dezena());
		Assert.assertEquals(38, concurso.getQua_dezena());
		Assert.assertEquals(28, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(3);
		Assert.assertEquals(673, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 15), concurso.getData());
		Assert.assertEquals(6, concurso.getPri_dezena());
		Assert.assertEquals(40, concurso.getSeg_dezena());
		Assert.assertEquals(37, concurso.getTer_dezena());
		Assert.assertEquals(11, concurso.getQua_dezena());
		Assert.assertEquals(20, concurso.getQui_dezena());
		Assert.assertEquals(34, concurso.getSex_dezena());

		concurso = resultados.get(4);
		Assert.assertEquals(674, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 18), concurso.getData());
		Assert.assertEquals(22, concurso.getPri_dezena());
		Assert.assertEquals(32, concurso.getSeg_dezena());
		Assert.assertEquals(18, concurso.getTer_dezena());
		Assert.assertEquals(29, concurso.getQua_dezena());
		Assert.assertEquals(42, concurso.getQui_dezena());
		Assert.assertEquals(38, concurso.getSex_dezena());

		concurso = resultados.get(5);
		Assert.assertEquals(675, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 22), concurso.getData());
		Assert.assertEquals(50, concurso.getPri_dezena());
		Assert.assertEquals(42, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(25, concurso.getQua_dezena());
		Assert.assertEquals(43, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(6);
		Assert.assertEquals(676, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 25), concurso.getData());
		Assert.assertEquals(49, concurso.getPri_dezena());
		Assert.assertEquals(32, concurso.getSeg_dezena());
		Assert.assertEquals(15, concurso.getTer_dezena());
		Assert.assertEquals(9, concurso.getQua_dezena());
		Assert.assertEquals(41, concurso.getQui_dezena());
		Assert.assertEquals(42, concurso.getSex_dezena());

		concurso = resultados.get(7);
		Assert.assertEquals(677, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 29), concurso.getData());
		Assert.assertEquals(25, concurso.getPri_dezena());
		Assert.assertEquals(10, concurso.getSeg_dezena());
		Assert.assertEquals(48, concurso.getTer_dezena());
		Assert.assertEquals(8, concurso.getQua_dezena());
		Assert.assertEquals(32, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = resultados.get(8);
		Assert.assertEquals(678, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 7, 2), concurso.getData());
		Assert.assertEquals(44, concurso.getPri_dezena());
		Assert.assertEquals(46, concurso.getSeg_dezena());
		Assert.assertEquals(31, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(40, concurso.getQui_dezena());
		Assert.assertEquals(42, concurso.getSex_dezena());

		concurso = resultados.get(9);
		Assert.assertEquals(679, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 7, 6), concurso.getData());
		Assert.assertEquals(37, concurso.getPri_dezena());
		Assert.assertEquals(21, concurso.getSeg_dezena());
		Assert.assertEquals(54, concurso.getTer_dezena());
		Assert.assertEquals(3, concurso.getQua_dezena());
		Assert.assertEquals(58, concurso.getQui_dezena());
		Assert.assertEquals(25, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoData_10() throws IOException {
		LocalDate inicio = new LocalDate(2005, 6, 2);
		LocalDate fim = new LocalDate(2005, 7, 8);
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(10, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(670, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 4), concurso.getData());
		Assert.assertEquals(42, concurso.getPri_dezena());
		Assert.assertEquals(59, concurso.getSeg_dezena());
		Assert.assertEquals(58, concurso.getTer_dezena());
		Assert.assertEquals(37, concurso.getQua_dezena());
		Assert.assertEquals(48, concurso.getQui_dezena());
		Assert.assertEquals(22, concurso.getSex_dezena());

		concurso = resultados.get(1);
		Assert.assertEquals(671, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 8), concurso.getData());
		Assert.assertEquals(27, concurso.getPri_dezena());
		Assert.assertEquals(16, concurso.getSeg_dezena());
		Assert.assertEquals(39, concurso.getTer_dezena());
		Assert.assertEquals(51, concurso.getQua_dezena());
		Assert.assertEquals(9, concurso.getQui_dezena());
		Assert.assertEquals(38, concurso.getSex_dezena());

		concurso = resultados.get(2);
		Assert.assertEquals(672, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 11), concurso.getData());
		Assert.assertEquals(43, concurso.getPri_dezena());
		Assert.assertEquals(34, concurso.getSeg_dezena());
		Assert.assertEquals(53, concurso.getTer_dezena());
		Assert.assertEquals(38, concurso.getQua_dezena());
		Assert.assertEquals(28, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(3);
		Assert.assertEquals(673, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 15), concurso.getData());
		Assert.assertEquals(6, concurso.getPri_dezena());
		Assert.assertEquals(40, concurso.getSeg_dezena());
		Assert.assertEquals(37, concurso.getTer_dezena());
		Assert.assertEquals(11, concurso.getQua_dezena());
		Assert.assertEquals(20, concurso.getQui_dezena());
		Assert.assertEquals(34, concurso.getSex_dezena());

		concurso = resultados.get(4);
		Assert.assertEquals(674, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 18), concurso.getData());
		Assert.assertEquals(22, concurso.getPri_dezena());
		Assert.assertEquals(32, concurso.getSeg_dezena());
		Assert.assertEquals(18, concurso.getTer_dezena());
		Assert.assertEquals(29, concurso.getQua_dezena());
		Assert.assertEquals(42, concurso.getQui_dezena());
		Assert.assertEquals(38, concurso.getSex_dezena());

		concurso = resultados.get(5);
		Assert.assertEquals(675, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 22), concurso.getData());
		Assert.assertEquals(50, concurso.getPri_dezena());
		Assert.assertEquals(42, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(25, concurso.getQua_dezena());
		Assert.assertEquals(43, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(6);
		Assert.assertEquals(676, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 25), concurso.getData());
		Assert.assertEquals(49, concurso.getPri_dezena());
		Assert.assertEquals(32, concurso.getSeg_dezena());
		Assert.assertEquals(15, concurso.getTer_dezena());
		Assert.assertEquals(9, concurso.getQua_dezena());
		Assert.assertEquals(41, concurso.getQui_dezena());
		Assert.assertEquals(42, concurso.getSex_dezena());

		concurso = resultados.get(7);
		Assert.assertEquals(677, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 29), concurso.getData());
		Assert.assertEquals(25, concurso.getPri_dezena());
		Assert.assertEquals(10, concurso.getSeg_dezena());
		Assert.assertEquals(48, concurso.getTer_dezena());
		Assert.assertEquals(8, concurso.getQua_dezena());
		Assert.assertEquals(32, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = resultados.get(8);
		Assert.assertEquals(678, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 7, 2), concurso.getData());
		Assert.assertEquals(44, concurso.getPri_dezena());
		Assert.assertEquals(46, concurso.getSeg_dezena());
		Assert.assertEquals(31, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(40, concurso.getQui_dezena());
		Assert.assertEquals(42, concurso.getSex_dezena());

		concurso = resultados.get(9);
		Assert.assertEquals(679, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 7, 6), concurso.getData());
		Assert.assertEquals(37, concurso.getPri_dezena());
		Assert.assertEquals(21, concurso.getSeg_dezena());
		Assert.assertEquals(54, concurso.getTer_dezena());
		Assert.assertEquals(3, concurso.getQua_dezena());
		Assert.assertEquals(58, concurso.getQui_dezena());
		Assert.assertEquals(25, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoNumero_01() throws IOException {
		int inicio = 1;
		int fim = 1;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

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
	public void testaResultadoNumero_02() throws IOException {
		int inicio = 0;
		int fim = 0;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(0, resultados.size());
	}

	@Test
	public void testaResultadoNumero_03() throws IOException {
		int inicio = 0;
		int fim = 1;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

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
	public void testaResultadoNumero_04() throws IOException {
		int inicio = -1;
		int fim = 1;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

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
	public void testaResultadoNumero_05() throws IOException {
		int inicio = 1538;
		int fim = 1538;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoNumero_06() throws IOException {
		int inicio = 1539;
		int fim = 1539;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(0, resultados.size());
	}

	@Test
	public void testaResultadoNumero_07() throws IOException {
		int inicio = 1538;
		int fim = 1539;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoNumero_08() throws IOException {
		int inicio = 1538;
		int fim = 1600;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(1, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(1538, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2013, 10, 11), concurso.getData());
		Assert.assertEquals(35, concurso.getPri_dezena());
		Assert.assertEquals(52, concurso.getSeg_dezena());
		Assert.assertEquals(27, concurso.getTer_dezena());
		Assert.assertEquals(53, concurso.getQua_dezena());
		Assert.assertEquals(57, concurso.getQui_dezena());
		Assert.assertEquals(23, concurso.getSex_dezena());
	}

	@Test
	public void testaResultadoNumero_09() throws IOException {
		int inicio = 670;
		int fim = 679;
		FiltrarResultados filtrarResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtrarResultados.getResultados(inicio, fim);
		Assert.assertEquals(10, resultados.size());

		Resultado concurso = resultados.get(0);
		Assert.assertEquals(670, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 4), concurso.getData());
		Assert.assertEquals(42, concurso.getPri_dezena());
		Assert.assertEquals(59, concurso.getSeg_dezena());
		Assert.assertEquals(58, concurso.getTer_dezena());
		Assert.assertEquals(37, concurso.getQua_dezena());
		Assert.assertEquals(48, concurso.getQui_dezena());
		Assert.assertEquals(22, concurso.getSex_dezena());

		concurso = resultados.get(1);
		Assert.assertEquals(671, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 8), concurso.getData());
		Assert.assertEquals(27, concurso.getPri_dezena());
		Assert.assertEquals(16, concurso.getSeg_dezena());
		Assert.assertEquals(39, concurso.getTer_dezena());
		Assert.assertEquals(51, concurso.getQua_dezena());
		Assert.assertEquals(9, concurso.getQui_dezena());
		Assert.assertEquals(38, concurso.getSex_dezena());

		concurso = resultados.get(2);
		Assert.assertEquals(672, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 11), concurso.getData());
		Assert.assertEquals(43, concurso.getPri_dezena());
		Assert.assertEquals(34, concurso.getSeg_dezena());
		Assert.assertEquals(53, concurso.getTer_dezena());
		Assert.assertEquals(38, concurso.getQua_dezena());
		Assert.assertEquals(28, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(3);
		Assert.assertEquals(673, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 15), concurso.getData());
		Assert.assertEquals(6, concurso.getPri_dezena());
		Assert.assertEquals(40, concurso.getSeg_dezena());
		Assert.assertEquals(37, concurso.getTer_dezena());
		Assert.assertEquals(11, concurso.getQua_dezena());
		Assert.assertEquals(20, concurso.getQui_dezena());
		Assert.assertEquals(34, concurso.getSex_dezena());

		concurso = resultados.get(4);
		Assert.assertEquals(674, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 18), concurso.getData());
		Assert.assertEquals(22, concurso.getPri_dezena());
		Assert.assertEquals(32, concurso.getSeg_dezena());
		Assert.assertEquals(18, concurso.getTer_dezena());
		Assert.assertEquals(29, concurso.getQua_dezena());
		Assert.assertEquals(42, concurso.getQui_dezena());
		Assert.assertEquals(38, concurso.getSex_dezena());

		concurso = resultados.get(5);
		Assert.assertEquals(675, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 22), concurso.getData());
		Assert.assertEquals(50, concurso.getPri_dezena());
		Assert.assertEquals(42, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(25, concurso.getQua_dezena());
		Assert.assertEquals(43, concurso.getQui_dezena());
		Assert.assertEquals(24, concurso.getSex_dezena());

		concurso = resultados.get(6);
		Assert.assertEquals(676, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 25), concurso.getData());
		Assert.assertEquals(49, concurso.getPri_dezena());
		Assert.assertEquals(32, concurso.getSeg_dezena());
		Assert.assertEquals(15, concurso.getTer_dezena());
		Assert.assertEquals(9, concurso.getQua_dezena());
		Assert.assertEquals(41, concurso.getQui_dezena());
		Assert.assertEquals(42, concurso.getSex_dezena());

		concurso = resultados.get(7);
		Assert.assertEquals(677, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 6, 29), concurso.getData());
		Assert.assertEquals(25, concurso.getPri_dezena());
		Assert.assertEquals(10, concurso.getSeg_dezena());
		Assert.assertEquals(48, concurso.getTer_dezena());
		Assert.assertEquals(8, concurso.getQua_dezena());
		Assert.assertEquals(32, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = resultados.get(8);
		Assert.assertEquals(678, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 7, 2), concurso.getData());
		Assert.assertEquals(44, concurso.getPri_dezena());
		Assert.assertEquals(46, concurso.getSeg_dezena());
		Assert.assertEquals(31, concurso.getTer_dezena());
		Assert.assertEquals(14, concurso.getQua_dezena());
		Assert.assertEquals(40, concurso.getQui_dezena());
		Assert.assertEquals(42, concurso.getSex_dezena());

		concurso = resultados.get(9);
		Assert.assertEquals(679, concurso.getNumero());
		Assert.assertEquals(new LocalDate(2005, 7, 6), concurso.getData());
		Assert.assertEquals(37, concurso.getPri_dezena());
		Assert.assertEquals(21, concurso.getSeg_dezena());
		Assert.assertEquals(54, concurso.getTer_dezena());
		Assert.assertEquals(3, concurso.getQua_dezena());
		Assert.assertEquals(58, concurso.getQui_dezena());
		Assert.assertEquals(25, concurso.getSex_dezena());
	}

	private List<Resultado> getResultados() throws IOException {
		if (carregarResultado == null) {
			File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
			carregarResultado = new CarregarResultados(htmlFile, null, null).carregarResultado();
		}
		return carregarResultado;
	}
}
