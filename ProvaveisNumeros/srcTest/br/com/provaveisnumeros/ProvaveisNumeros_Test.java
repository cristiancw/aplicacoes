package br.com.provaveisnumeros;

import java.io.IOException;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.Configuracao;
import br.com.EnFequencia;
import br.com.EnFiltro;
import br.com.Resultado;

public class ProvaveisNumeros_Test {

	@Test
	public void testaFiltroAnoMaisFequentes_01() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(1996);
		configuracao.setFrequencia(EnFequencia.MAIS_FREQUENTES);
		configuracao.setCaminho("C:/Eclipse/workspace/aplicacoes/ProvaveisNumeros/srcTest");

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(2010);
		configuracao.setFrequencia(EnFequencia.MAIS_FREQUENTES);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(1996);
		configuracao.setFrequencia(EnFequencia.MENOS_FREQUENTES);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.POR_ANO);
		configuracao.setAno(2010);
		configuracao.setFrequencia(EnFequencia.MENOS_FREQUENTES);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 27));
		configuracao.setDataFinal(new LocalDate(2011, 8, 5));
		configuracao.setFrequencia(EnFequencia.MAIS_FREQUENTES);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 24));
		configuracao.setDataFinal(new LocalDate(2001, 3, 24));
		configuracao.setFrequencia(EnFequencia.MAIS_FREQUENTES);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 27));
		configuracao.setDataFinal(new LocalDate(2011, 8, 5));
		configuracao.setFrequencia(EnFequencia.MENOS_FREQUENTES);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2001, 3, 24));
		configuracao.setDataFinal(new LocalDate(2001, 3, 24));
		configuracao.setFrequencia(EnFequencia.MENOS_FREQUENTES);
		configuracao.setCaminho("C:/Eclipse/workspace/aplicacoes/ProvaveisNumeros/srcTest");

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.TUDO_ATE_HOJE);
		configuracao.setFrequencia(EnFequencia.MAIS_FREQUENTES);
		configuracao.setCaminho("C:/Eclipse/workspace/aplicacoes/ProvaveisNumeros/srcTest");

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.TUDO_ATE_HOJE);
		configuracao.setFrequencia(EnFequencia.MENOS_FREQUENTES);
		configuracao.setCaminho("C:/Eclipse/workspace/aplicacoes/ProvaveisNumeros/srcTest");

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
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
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
			provaveisNumeros.getResultados();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("A frequência está nula", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("A frequência está nula", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_02() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setAno(-10);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
			provaveisNumeros.getResultados();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O ano informado é negativo: -10", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O ano informado é negativo: -10", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_03() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(null);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
			provaveisNumeros.getResultados();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O filtro informado é nulo", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O filtro informado é nulo", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_04() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.POR_ANO);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
			provaveisNumeros.getResultados();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O filtro informado está definido para filtrar por ano mas não existe um ano informado", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O filtro informado está definido para filtrar por ano mas não existe um ano informado", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_05() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
			provaveisNumeros.getResultados();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("O filtro informado está definido por período mas a data inicial ou data final não foi informada", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("O filtro informado está definido por período mas a data inicial ou data final não foi informada", configuracao.getMotivoInvalido());
		}
	}

	@Test
	public void testaValidacao_06() throws IOException {
		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2013, 10, 10));
		configuracao.setDataFinal(new LocalDate(2013, 9, 10));

		try {
			ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
			provaveisNumeros.getResultados();
		} catch (Exception e) {
			Assert.assertTrue(e instanceof IllegalStateException);
			Assert.assertEquals("A data inicial é maior que data final", e.getMessage());

			Assert.assertFalse(configuracao.isValido());
			Assert.assertEquals("A data inicial é maior que data final", configuracao.getMotivoInvalido());
		}
	}
}
