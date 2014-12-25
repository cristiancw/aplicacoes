package br.com.provaveisnumeros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.Configuracao;
import br.com.EnFiltro;
import br.com.EnFrequencia;
import br.com.Resultado;
import br.com.provaveisnumeros.parse.CarregarResultados;

public class ProvaveisNumeros_Test {

	@Test
	public void testaBuscaFrequenciaSemCarregar() {
		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
		try {
			provaveisNumeros.getNumerosFrequentes();
			Assert.fail("Deveria ter gerado uma exceção");
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("É necessário carregar os dados antes de buscar sua frequencia.", e.getMessage());
		}
	}

	@Test
	public void testaBuscaFrequenciaCarregada() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(1996, 3, 11));
		configuracao.setDataFinal(new LocalDate(1997, 3, 16));
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);

		List<Integer> maisFrequentes = provaveisNumeros.getNumerosFrequentes();
		Assert.assertEquals(7, maisFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(5), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(17), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(33), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(38), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(43), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(47), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(56), maisFrequentes.get(i++));
	}

	@Test
	public void testaBuscaResultadosSemCarregar() {
		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
		try {
			provaveisNumeros.getResultados();
			Assert.fail("Deveria ter gerado uma exceção");
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("É necessário carregar os dados antes de buscar sua combinação.", e.getMessage());
		}
	}

	@Test
	public void testaListaAnos() throws IOException {
		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		List<Integer> listaAnos = provaveisNumeros.getListaAnos();
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
	public void testaFiltroAnoMaisFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(1996);
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(28, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(33, resultado.getQua_dezena());
		Assert.assertEquals(38, resultado.getQui_dezena());
		Assert.assertEquals(43, resultado.getSex_dezena());

		resultado = resultados.get(1);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(33, resultado.getQua_dezena());
		Assert.assertEquals(38, resultado.getQui_dezena());
		Assert.assertEquals(47, resultado.getSex_dezena());

		resultado = resultados.get(2);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(33, resultado.getQua_dezena());
		Assert.assertEquals(38, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(3);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(33, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(47, resultado.getSex_dezena());

		resultado = resultados.get(4);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(33, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(5);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(33, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(6);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(47, resultado.getSex_dezena());

		resultado = resultados.get(7);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(8);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(9);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(10);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(47, resultado.getSex_dezena());

		resultado = resultados.get(11);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(12);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(13);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(14);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(6, resultado.getSeg_dezena());
		Assert.assertEquals(38, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(15);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(47, resultado.getSex_dezena());

		resultado = resultados.get(16);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(17);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(18);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(19);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(38, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(20);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(33, resultado.getSeg_dezena());
		Assert.assertEquals(38, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(21);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(6, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(47, resultado.getSex_dezena());

		resultado = resultados.get(22);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(6, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(43, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(23);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(6, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(24);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(6, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(25);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(6, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(38, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(26);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(6, resultado.getPri_dezena());
		Assert.assertEquals(33, resultado.getSeg_dezena());
		Assert.assertEquals(38, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());

		resultado = resultados.get(27);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(17, resultado.getPri_dezena());
		Assert.assertEquals(33, resultado.getSeg_dezena());
		Assert.assertEquals(38, resultado.getTer_dezena());
		Assert.assertEquals(43, resultado.getQua_dezena());
		Assert.assertEquals(47, resultado.getQui_dezena());
		Assert.assertEquals(56, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroAnoMaisFequentes_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(2010);
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(84, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(10, resultado.getSeg_dezena());
		Assert.assertEquals(20, resultado.getTer_dezena());
		Assert.assertEquals(28, resultado.getQua_dezena());
		Assert.assertEquals(30, resultado.getQui_dezena());
		Assert.assertEquals(31, resultado.getSex_dezena());

		resultado = resultados.get(20);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(10, resultado.getSeg_dezena());
		Assert.assertEquals(28, resultado.getTer_dezena());
		Assert.assertEquals(30, resultado.getQua_dezena());
		Assert.assertEquals(31, resultado.getQui_dezena());
		Assert.assertEquals(48, resultado.getSex_dezena());

		resultado = resultados.get(41);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(20, resultado.getSeg_dezena());
		Assert.assertEquals(28, resultado.getTer_dezena());
		Assert.assertEquals(31, resultado.getQua_dezena());
		Assert.assertEquals(48, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());

		resultado = resultados.get(61);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(10, resultado.getPri_dezena());
		Assert.assertEquals(20, resultado.getSeg_dezena());
		Assert.assertEquals(28, resultado.getTer_dezena());
		Assert.assertEquals(30, resultado.getQua_dezena());
		Assert.assertEquals(49, resultado.getQui_dezena());
		Assert.assertEquals(60, resultado.getSex_dezena());

		resultado = resultados.get(83);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(28, resultado.getPri_dezena());
		Assert.assertEquals(30, resultado.getSeg_dezena());
		Assert.assertEquals(31, resultado.getTer_dezena());
		Assert.assertEquals(48, resultado.getQua_dezena());
		Assert.assertEquals(49, resultado.getQui_dezena());
		Assert.assertEquals(60, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroAnoManosFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(1996);
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(462, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(9, resultado.getPri_dezena());
		Assert.assertEquals(18, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(31, resultado.getQua_dezena());
		Assert.assertEquals(32, resultado.getQui_dezena());
		Assert.assertEquals(34, resultado.getSex_dezena());

		resultado = resultados.get(114);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(9, resultado.getPri_dezena());
		Assert.assertEquals(18, resultado.getSeg_dezena());
		Assert.assertEquals(34, resultado.getTer_dezena());
		Assert.assertEquals(35, resultado.getQua_dezena());
		Assert.assertEquals(41, resultado.getQui_dezena());
		Assert.assertEquals(44, resultado.getSex_dezena());

		resultado = resultados.get(230);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(9, resultado.getPri_dezena());
		Assert.assertEquals(31, resultado.getSeg_dezena());
		Assert.assertEquals(40, resultado.getTer_dezena());
		Assert.assertEquals(41, resultado.getQua_dezena());
		Assert.assertEquals(44, resultado.getQui_dezena());
		Assert.assertEquals(48, resultado.getSex_dezena());

		resultado = resultados.get(345);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(18, resultado.getPri_dezena());
		Assert.assertEquals(31, resultado.getSeg_dezena());
		Assert.assertEquals(34, resultado.getTer_dezena());
		Assert.assertEquals(35, resultado.getQua_dezena());
		Assert.assertEquals(41, resultado.getQui_dezena());
		Assert.assertEquals(44, resultado.getSex_dezena());

		resultado = resultados.get(461);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(34, resultado.getPri_dezena());
		Assert.assertEquals(35, resultado.getSeg_dezena());
		Assert.assertEquals(40, resultado.getTer_dezena());
		Assert.assertEquals(41, resultado.getQua_dezena());
		Assert.assertEquals(44, resultado.getQui_dezena());
		Assert.assertEquals(48, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroAnoMenosFequentes_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(2010);
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(1, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(16, resultado.getPri_dezena());
		Assert.assertEquals(18, resultado.getSeg_dezena());
		Assert.assertEquals(24, resultado.getTer_dezena());
		Assert.assertEquals(38, resultado.getQua_dezena());
		Assert.assertEquals(42, resultado.getQui_dezena());
		Assert.assertEquals(59, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroPeriodoDefinidoMaisFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 27));
		configuracao.setDataFinal(new LocalDate(2011, 8, 5));
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(28, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(8, resultado.getTer_dezena());
		Assert.assertEquals(17, resultado.getQua_dezena());
		Assert.assertEquals(23, resultado.getQui_dezena());
		Assert.assertEquals(29, resultado.getSex_dezena());

		resultado = resultados.get(7);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(8, resultado.getTer_dezena());
		Assert.assertEquals(23, resultado.getQua_dezena());
		Assert.assertEquals(29, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());

		resultado = resultados.get(14);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(23, resultado.getTer_dezena());
		Assert.assertEquals(29, resultado.getQua_dezena());
		Assert.assertEquals(33, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());

		resultado = resultados.get(21);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(8, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(23, resultado.getQua_dezena());
		Assert.assertEquals(29, resultado.getQui_dezena());
		Assert.assertEquals(33, resultado.getSex_dezena());

		resultado = resultados.get(27);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(8, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(23, resultado.getTer_dezena());
		Assert.assertEquals(29, resultado.getQua_dezena());
		Assert.assertEquals(33, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroPeriodoDefinidoMaisFequentes_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 24));
		configuracao.setDataFinal(new LocalDate(2001, 3, 24));
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(1, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(1, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(13, resultado.getTer_dezena());
		Assert.assertEquals(25, resultado.getQua_dezena());
		Assert.assertEquals(31, resultado.getQui_dezena());
		Assert.assertEquals(33, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroPeriodoDefinidoMenosFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 27));
		configuracao.setDataFinal(new LocalDate(2011, 8, 5));
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(7, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(45, resultado.getQui_dezena());
		Assert.assertEquals(46, resultado.getSex_dezena());

		resultado = resultados.get(1);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(45, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(2);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(3);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(4);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(5);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(25, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(6);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(22, resultado.getPri_dezena());
		Assert.assertEquals(25, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroPeriodoDefinidoMenosFequentes_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 24));
		configuracao.setDataFinal(new LocalDate(2001, 3, 24));
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(1, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(1, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(13, resultado.getTer_dezena());
		Assert.assertEquals(25, resultado.getQua_dezena());
		Assert.assertEquals(31, resultado.getQui_dezena());
		Assert.assertEquals(33, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroNumeroConcursoMaisFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(265);
		configuracao.setConcursoFinal(1306);
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(28, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(8, resultado.getTer_dezena());
		Assert.assertEquals(17, resultado.getQua_dezena());
		Assert.assertEquals(23, resultado.getQui_dezena());
		Assert.assertEquals(29, resultado.getSex_dezena());

		resultado = resultados.get(7);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(8, resultado.getTer_dezena());
		Assert.assertEquals(23, resultado.getQua_dezena());
		Assert.assertEquals(29, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());

		resultado = resultados.get(14);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(23, resultado.getTer_dezena());
		Assert.assertEquals(29, resultado.getQua_dezena());
		Assert.assertEquals(33, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());

		resultado = resultados.get(21);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(5, resultado.getPri_dezena());
		Assert.assertEquals(8, resultado.getSeg_dezena());
		Assert.assertEquals(17, resultado.getTer_dezena());
		Assert.assertEquals(23, resultado.getQua_dezena());
		Assert.assertEquals(29, resultado.getQui_dezena());
		Assert.assertEquals(33, resultado.getSex_dezena());

		resultado = resultados.get(27);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(8, resultado.getPri_dezena());
		Assert.assertEquals(17, resultado.getSeg_dezena());
		Assert.assertEquals(23, resultado.getTer_dezena());
		Assert.assertEquals(29, resultado.getQua_dezena());
		Assert.assertEquals(33, resultado.getQui_dezena());
		Assert.assertEquals(49, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroNumeroConcursoMaisFequentes_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(264);
		configuracao.setConcursoFinal(264);
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(1, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(1, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(13, resultado.getTer_dezena());
		Assert.assertEquals(25, resultado.getQua_dezena());
		Assert.assertEquals(31, resultado.getQui_dezena());
		Assert.assertEquals(33, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroNumeroConcursoMenosFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(265);
		configuracao.setConcursoFinal(1306);
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(7, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(45, resultado.getQui_dezena());
		Assert.assertEquals(46, resultado.getSex_dezena());

		resultado = resultados.get(1);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(45, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(2);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(3);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(25, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(4);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(5);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(25, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(6);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(22, resultado.getPri_dezena());
		Assert.assertEquals(25, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(45, resultado.getQua_dezena());
		Assert.assertEquals(46, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroNumeroConcursoMenosFequentes_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(264);
		configuracao.setConcursoFinal(264);
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(1, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(1, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(13, resultado.getTer_dezena());
		Assert.assertEquals(25, resultado.getQua_dezena());
		Assert.assertEquals(31, resultado.getQui_dezena());
		Assert.assertEquals(33, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroTudoAteHojeMaisFequentes() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.TUDO_ATE_HOJE);
		configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(1, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(4, resultado.getPri_dezena());
		Assert.assertEquals(5, resultado.getSeg_dezena());
		Assert.assertEquals(33, resultado.getTer_dezena());
		Assert.assertEquals(51, resultado.getQua_dezena());
		Assert.assertEquals(53, resultado.getQui_dezena());
		Assert.assertEquals(54, resultado.getSex_dezena());
	}

	@Test
	public void testaFiltroTudoAteHojeMenosFequentes() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.TUDO_ATE_HOJE);
		configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);

		File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
		List<Resultado> historicoResultados = new CarregarResultados(htmlFile, null, null).carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(historicoResultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> resultados = provaveisNumeros.getResultados();
		Assert.assertEquals(28, resultados.size());

		Resultado resultado = resultados.get(0);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(9, resultado.getPri_dezena());
		Assert.assertEquals(15, resultado.getSeg_dezena());
		Assert.assertEquals(21, resultado.getTer_dezena());
		Assert.assertEquals(22, resultado.getQua_dezena());
		Assert.assertEquals(26, resultado.getQui_dezena());
		Assert.assertEquals(39, resultado.getSex_dezena());

		resultado = resultados.get(7);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(9, resultado.getPri_dezena());
		Assert.assertEquals(15, resultado.getSeg_dezena());
		Assert.assertEquals(21, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(39, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(14);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(9, resultado.getPri_dezena());
		Assert.assertEquals(15, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(39, resultado.getQua_dezena());
		Assert.assertEquals(45, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());

		resultado = resultados.get(21);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(15, resultado.getPri_dezena());
		Assert.assertEquals(21, resultado.getSeg_dezena());
		Assert.assertEquals(22, resultado.getTer_dezena());
		Assert.assertEquals(26, resultado.getQua_dezena());
		Assert.assertEquals(39, resultado.getQui_dezena());
		Assert.assertEquals(45, resultado.getSex_dezena());

		resultado = resultados.get(27);
		Assert.assertEquals(0, resultado.getNumero());
		Assert.assertEquals(new LocalDate(), resultado.getData());
		Assert.assertEquals(21, resultado.getPri_dezena());
		Assert.assertEquals(22, resultado.getSeg_dezena());
		Assert.assertEquals(26, resultado.getTer_dezena());
		Assert.assertEquals(39, resultado.getQua_dezena());
		Assert.assertEquals(45, resultado.getQui_dezena());
		Assert.assertEquals(55, resultado.getSex_dezena());
	}

	@Test
	public void testaValidacao_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFrequencia(null);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("A frequência está nula.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("A frequência está nula.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setAno(-10);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O ano informado é negativo: -10.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O ano informado é negativo: -10.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_03() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(null);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O filtro informado é nulo.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O filtro informado é nulo.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_04() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.POR_ANO);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O filtro informado está definido para filtrar por ano mas não existe um ano informado.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O filtro informado está definido para filtrar por ano mas não existe um ano informado.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_05() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O filtro informado está definido por período mas a data inicial ou data final não foi informada.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O filtro informado está definido por período mas a data inicial ou data final não foi informada.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_06() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2013, 10, 10));
		configuracao.setDataFinal(new LocalDate(2013, 9, 10));

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("A data inicial é maior que data final.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("A data inicial é maior que data final.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_07() throws IOException {
		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(null);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O calculo não foi configurado corretamente.", e.getMessage());
		}
	}

	@Test
	public void testaValidacao_08() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(-1);
		configuracao.setConcursoFinal(0);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("Os números do intervalo entre concursos não pode ser negativo.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("Os números do intervalo entre concursos não pode ser negativo.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_09() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(0);
		configuracao.setConcursoFinal(-2);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("Os números do intervalo entre concursos não pode ser negativo.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("Os números do intervalo entre concursos não pode ser negativo.", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_10() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
		configuracao.setConcursoInicial(10);
		configuracao.setConcursoFinal(8);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(new ArrayList<Resultado>());
			provaveisNumeros.filtrar(configuracao);
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O número inicial do concurso não pode ser maior que o número fina.", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O número inicial do concurso não pode ser maior que o número fina.", configuracao.getMotivoInvalido());
		}
	}
}
