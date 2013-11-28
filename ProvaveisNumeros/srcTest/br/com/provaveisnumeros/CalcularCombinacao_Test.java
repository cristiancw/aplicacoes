package br.com.provaveisnumeros;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.Resultado;

public class CalcularCombinacao_Test {

	@Test
	public void testaCombinacao_01() {
		List<Integer> frequentes = new ArrayList<Integer>();
		frequentes.add(1);
		frequentes.add(2);
		frequentes.add(3);
		frequentes.add(4);
		frequentes.add(5);
		frequentes.add(6);
		List<Resultado> combinacoes = new CalcularCombinacao().calcular(frequentes);

		Assert.assertEquals(1, combinacoes.size());
		Resultado concurso = combinacoes.get(0);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(5, concurso.getQui_dezena());
		Assert.assertEquals(6, concurso.getSex_dezena());
	}

	@Test
	public void testaCombinacao_02() {
		List<Integer> frequentes = new ArrayList<Integer>();
		frequentes.add(1);
		frequentes.add(2);
		frequentes.add(3);
		frequentes.add(4);
		frequentes.add(5);
		frequentes.add(6);
		frequentes.add(7);
		List<Resultado> combinacoes = new CalcularCombinacao().calcular(frequentes);

		Assert.assertEquals(7, combinacoes.size());
		Resultado concurso = combinacoes.get(0);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(5, concurso.getQui_dezena());
		Assert.assertEquals(6, concurso.getSex_dezena());

		concurso = combinacoes.get(1);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(5, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(2);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(3);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(4);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(5);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(6);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());
	}

	@Test
	public void testaCombinacao_03() {
		List<Integer> frequentes = new ArrayList<Integer>();
		frequentes.add(1);
		frequentes.add(2);
		frequentes.add(3);
		frequentes.add(4);
		frequentes.add(5);
		frequentes.add(6);
		frequentes.add(7);
		frequentes.add(8);
		List<Resultado> combinacoes = new CalcularCombinacao().calcular(frequentes);

		Assert.assertEquals(28, combinacoes.size());
		Resultado concurso = combinacoes.get(0);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(5, concurso.getQui_dezena());
		Assert.assertEquals(6, concurso.getSex_dezena());

		concurso = combinacoes.get(1);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(5, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(8);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(7, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());

		concurso = combinacoes.get(15);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(7, concurso.getSex_dezena());

		concurso = combinacoes.get(16);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());

		concurso = combinacoes.get(22);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());

		concurso = combinacoes.get(27);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(3, concurso.getPri_dezena());
		Assert.assertEquals(4, concurso.getSeg_dezena());
		Assert.assertEquals(5, concurso.getTer_dezena());
		Assert.assertEquals(6, concurso.getQua_dezena());
		Assert.assertEquals(7, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());
	}

	@Test
	public void testaCombinacao_04() {
		List<Integer> frequentes = new ArrayList<Integer>();
		frequentes.add(1);
		frequentes.add(2);
		frequentes.add(3);
		frequentes.add(4);
		frequentes.add(5);
		frequentes.add(6);
		frequentes.add(7);
		frequentes.add(8);
		frequentes.add(9);
		List<Resultado> combinacoes = new CalcularCombinacao().calcular(frequentes);

		Assert.assertEquals(84, combinacoes.size());
		Resultado concurso = combinacoes.get(0);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(4, concurso.getQua_dezena());
		Assert.assertEquals(5, concurso.getQui_dezena());
		Assert.assertEquals(6, concurso.getSex_dezena());

		concurso = combinacoes.get(12);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(3, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(9, concurso.getSex_dezena());

		concurso = combinacoes.get(24);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(2, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(7, concurso.getQui_dezena());
		Assert.assertEquals(9, concurso.getSex_dezena());

		concurso = combinacoes.get(36);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(5, concurso.getQua_dezena());
		Assert.assertEquals(6, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());

		concurso = combinacoes.get(44);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(1, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(4, concurso.getTer_dezena());
		Assert.assertEquals(7, concurso.getQua_dezena());
		Assert.assertEquals(8, concurso.getQui_dezena());
		Assert.assertEquals(9, concurso.getSex_dezena());

		concurso = combinacoes.get(66);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(3, concurso.getSeg_dezena());
		Assert.assertEquals(5, concurso.getTer_dezena());
		Assert.assertEquals(6, concurso.getQua_dezena());
		Assert.assertEquals(7, concurso.getQui_dezena());
		Assert.assertEquals(8, concurso.getSex_dezena());

		concurso = combinacoes.get(83);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(4, concurso.getPri_dezena());
		Assert.assertEquals(5, concurso.getSeg_dezena());
		Assert.assertEquals(6, concurso.getTer_dezena());
		Assert.assertEquals(7, concurso.getQua_dezena());
		Assert.assertEquals(8, concurso.getQui_dezena());
		Assert.assertEquals(9, concurso.getSex_dezena());
	}

	@Test
	public void testaCombinacao_05() {
		List<Integer> frequentes = new ArrayList<Integer>();
		frequentes.add(10);
		frequentes.add(20);
		frequentes.add(30);
		frequentes.add(40);
		frequentes.add(50);
		frequentes.add(60);
		List<Resultado> combinacoes = new CalcularCombinacao().calcular(frequentes);

		Assert.assertEquals(1, combinacoes.size());
		Resultado concurso = combinacoes.get(0);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(10, concurso.getPri_dezena());
		Assert.assertEquals(20, concurso.getSeg_dezena());
		Assert.assertEquals(30, concurso.getTer_dezena());
		Assert.assertEquals(40, concurso.getQua_dezena());
		Assert.assertEquals(50, concurso.getQui_dezena());
		Assert.assertEquals(60, concurso.getSex_dezena());
	}

	@Test
	public void testaCombinacao_06() {
		List<Integer> frequentes = new ArrayList<Integer>();
		frequentes.add(2);
		frequentes.add(4);
		frequentes.add(8);
		frequentes.add(16);
		frequentes.add(32);
		frequentes.add(44);
		frequentes.add(55);
		List<Resultado> combinacoes = new CalcularCombinacao().calcular(frequentes);

		Assert.assertEquals(7, combinacoes.size());
		Resultado concurso = combinacoes.get(0);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(4, concurso.getSeg_dezena());
		Assert.assertEquals(8, concurso.getTer_dezena());
		Assert.assertEquals(16, concurso.getQua_dezena());
		Assert.assertEquals(32, concurso.getQui_dezena());
		Assert.assertEquals(44, concurso.getSex_dezena());

		concurso = combinacoes.get(1);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(4, concurso.getSeg_dezena());
		Assert.assertEquals(8, concurso.getTer_dezena());
		Assert.assertEquals(16, concurso.getQua_dezena());
		Assert.assertEquals(32, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = combinacoes.get(2);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(4, concurso.getSeg_dezena());
		Assert.assertEquals(8, concurso.getTer_dezena());
		Assert.assertEquals(16, concurso.getQua_dezena());
		Assert.assertEquals(44, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = combinacoes.get(3);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(4, concurso.getSeg_dezena());
		Assert.assertEquals(8, concurso.getTer_dezena());
		Assert.assertEquals(32, concurso.getQua_dezena());
		Assert.assertEquals(44, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = combinacoes.get(4);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(4, concurso.getSeg_dezena());
		Assert.assertEquals(16, concurso.getTer_dezena());
		Assert.assertEquals(32, concurso.getQua_dezena());
		Assert.assertEquals(44, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = combinacoes.get(5);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(2, concurso.getPri_dezena());
		Assert.assertEquals(8, concurso.getSeg_dezena());
		Assert.assertEquals(16, concurso.getTer_dezena());
		Assert.assertEquals(32, concurso.getQua_dezena());
		Assert.assertEquals(44, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());

		concurso = combinacoes.get(6);
		Assert.assertEquals(0, concurso.getNumero());
		Assert.assertEquals(new LocalDate(), concurso.getData());
		Assert.assertEquals(4, concurso.getPri_dezena());
		Assert.assertEquals(8, concurso.getSeg_dezena());
		Assert.assertEquals(16, concurso.getTer_dezena());
		Assert.assertEquals(32, concurso.getQua_dezena());
		Assert.assertEquals(44, concurso.getQui_dezena());
		Assert.assertEquals(55, concurso.getSex_dezena());
	}

}
