package br.com.provaveisnumeros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.Configuracao;
import br.com.EnFequencia;
import br.com.EnFiltro;
import br.com.Resultado;

public class ProvaveisNumeros {

	public List<Resultado> executar(final Configuracao configuracao) throws IOException {
		// Carrega os resultados
		CarregarResultados carregarResultados = new CarregarResultados();
		if (configuracao.isBaixarNovoArquivo()) {
			carregarResultados.baixar();
		}
		List<Resultado> resultados = carregarResultados.carregarResultado();

		// Filtra os resultados
		FiltrarResultados filtraResultados = new FiltrarResultados(resultados);
		EnFiltro filtro = configuracao.getFiltro();
		switch (filtro) {
		case POR_ANO:
			resultados = filtraResultados.getResultados(configuracao.getAno());
			break;
		case PERIODO_DEFINIDO:
			resultados = filtraResultados.getResultados(configuracao.getDataInicial(), configuracao.getDataFinal());
			break;
		default: // TUDO_ATE_HOJE
			resultados = filtraResultados.getResultados();
			break;
		}

		// Busca os mais/menos frequentes
		BuscaFrequencia calculaResultadoProvavel = new BuscaFrequencia(resultados);
		EnFequencia frequencia = configuracao.getFrequencia();
		List<Integer> frequentes = new ArrayList<Integer>(0);
		if (EnFequencia.MAIS_FREQUENTES == frequencia) {
			frequentes = calculaResultadoProvavel.getMaisFrequentes();
		} else {
			frequentes = calculaResultadoProvavel.getMenosFrequentes();
		}

		// Calcular as combinações
		CalcularCombinacao calcularCombinacao = new CalcularCombinacao();
		List<Resultado> combinacoes = calcularCombinacao.calcular(frequentes);

		return combinacoes;
	}
}
