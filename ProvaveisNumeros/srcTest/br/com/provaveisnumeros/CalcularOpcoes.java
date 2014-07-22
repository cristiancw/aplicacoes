package br.com.provaveisnumeros;

import java.io.IOException;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.Configuracao;
import br.com.EnFequencia;
import br.com.EnFiltro;
import br.com.Resultado;

public class CalcularOpcoes {

	public static void main(String[] args) throws IOException {
		EnFequencia frequencia = EnFequencia.MAIS_FREQUENTES;

		Configuracao configuracao = new Configuracao();
		configuracao.setBaixarNovoArquivo(false);
		configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
		configuracao.setDataInicial(new LocalDate(2014, 1, 1));
		configuracao.setDataFinal(new LocalDate());
		configuracao.setFrequencia(frequencia);

		ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(configuracao);
		List<Resultado> executar = provaveisNumeros.getResultados();

		System.out.println("Existem " + executar.size() + " possibilidades.");
		System.out.println(frequencia.toString() + ":" + provaveisNumeros.getFrequentes());
		System.out.println("Elas são:");
		for (Resultado resultado : executar) {
			System.out.println(resultado);
		}
	}
}
