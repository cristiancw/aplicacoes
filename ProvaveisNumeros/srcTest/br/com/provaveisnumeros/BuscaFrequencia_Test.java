package br.com.provaveisnumeros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import br.com.Resultado;
import br.com.provaveisnumeros.parse.CarregarResultados;

public class BuscaFrequencia_Test {

	private List<Resultado> carregarResultado;

	@Test
	public void testaResultadosMaisFrequentesMaisFrequentes_01() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(new LocalDate(1996, 3, 11), new LocalDate(1996, 3, 18));
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> maisFrequentes = buscaFrequencia.getMaisFrequentes();
		Assert.assertEquals(11, maisFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(4), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(5), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(9), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(30), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(33), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(37), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(39), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(41), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(43), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(49), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(52), maisFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMaisFrequentes_02() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(new LocalDate(1996, 3, 11), new LocalDate(1997, 3, 16));
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> maisFrequentes = buscaFrequencia.getMaisFrequentes();
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
	public void testaResultadosMaisFrequentes_03() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(new LocalDate(1996, 3, 11), new LocalDate(2007, 3, 11));
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> maisFrequentes = buscaFrequencia.getMaisFrequentes();
		Assert.assertEquals(7, maisFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(5), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(13), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(16), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(23), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(24), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(42), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(54), maisFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMaisFrequentes_04() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(2000);
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> maisFrequentes = buscaFrequencia.getMaisFrequentes();
		Assert.assertEquals(14, maisFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(7), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(16), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(21), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(30), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(32), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(37), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(40), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(41), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(42), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(44), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(45), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(55), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(57), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(59), maisFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMaisFrequentes_05() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(2010);
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> maisFrequentes = buscaFrequencia.getMaisFrequentes();
		Assert.assertEquals(9, maisFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(5), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(10), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(20), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(28), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(30), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(31), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(48), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(49), maisFrequentes.get(i++));
		Assert.assertEquals(new Integer(60), maisFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMaisFrequentes_06() throws IOException {
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(new ArrayList<Resultado>());
		List<Integer> maisFrequentes = buscaFrequencia.getMaisFrequentes();
		Assert.assertEquals(0, maisFrequentes.size());
	}

	@Test
	public void testaResultadosMenosFrequentesMaisFrequentes_01() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(new LocalDate(1996, 3, 11), new LocalDate(1996, 3, 18));
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> menosFrequentes = buscaFrequencia.getMenosFrequentes();
		Assert.assertEquals(10, menosFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(4), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(5), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(9), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(30), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(33), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(37), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(39), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(43), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(49), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(52), menosFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMenosFrequentes_02() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(new LocalDate(1996, 3, 11), new LocalDate(1997, 3, 16));
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> menosFrequentes = buscaFrequencia.getMenosFrequentes();
		Assert.assertEquals(6, menosFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(26), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(31), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(34), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(40), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(41), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(48), menosFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMenosFrequentes_03() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(new LocalDate(1996, 3, 11), new LocalDate(2007, 3, 11));
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> menosFrequentes = buscaFrequencia.getMenosFrequentes();
		Assert.assertEquals(7, menosFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(2), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(9), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(20), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(21), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(26), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(39), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(55), menosFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMenosFrequentes_04() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(2000);
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> menosFrequentes = buscaFrequencia.getMenosFrequentes();
		Assert.assertEquals(7, menosFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(1), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(5), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(8), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(9), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(14), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(17), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(39), menosFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMenosFrequentes_05() throws IOException {
		FiltrarResultados filtraResultados = new FiltrarResultados(getResultados());
		List<Resultado> resultados = filtraResultados.getResultados(2010);
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(resultados);
		List<Integer> menosFrequentes = buscaFrequencia.getMenosFrequentes();
		Assert.assertEquals(6, menosFrequentes.size());

		int i = 0;
		Assert.assertEquals(new Integer(16), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(18), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(24), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(38), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(42), menosFrequentes.get(i++));
		Assert.assertEquals(new Integer(59), menosFrequentes.get(i++));
	}

	@Test
	public void testaResultadosMenosFrequentes_06() throws IOException {
		BuscaFrequencia buscaFrequencia = new BuscaFrequencia(new ArrayList<Resultado>());
		List<Integer> menosFrequentes = buscaFrequencia.getMenosFrequentes();
		Assert.assertEquals(0, menosFrequentes.size());
	}

	private List<Resultado> getResultados() throws IOException {
		if (carregarResultado == null) {
			File htmlFile = new File(System.getProperty("user.dir") + "/srcTest/" + CarregarResultados.HTML_FILE);
			carregarResultado = new CarregarResultados(htmlFile, null, null).carregarResultado();
		}
		return carregarResultado;
	}
}
