package br.com;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.provaveisnumeros.ProvaveisNumeros;
import br.com.provaveisnumeros.parse.CarregarResultados;

public class CalcularOpcoes {

	public static void main(String[] args) throws IOException {
		EnFrequencia frequencia = EnFrequencia.MAIS_FREQUENTES;

		Configuracao configuracao = new Configuracao();
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2014, 1, 1));
		configuracao.setDataFinal(new LocalDate());
		configuracao.setFrequencia(frequencia);

		final String caminho = System.getProperty("user.dir") + "\\";
		File htmlFile = new File(caminho + CarregarResultados.HTML_FILE);
		CarregarResultados carregarResultados = new CarregarResultados(htmlFile, null, null);
		List<Resultado> resultados = carregarResultados.carregarResultado();

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(resultados);
		provaveisNumeros.filtrar(configuracao);
		List<Resultado> executar = provaveisNumeros.getResultados();

		System.out.println("Existem " + executar.size() + " possibilidades.");
		System.out.println(frequencia.toString() + ":" + provaveisNumeros.getNumerosFrequentes());
		System.out.println("Elas são:");
		for (Resultado resultado : executar) {
			System.out.println(resultado);
		}
	}
}
