package br.com.provaveisnumeros;

import java.io.IOException;
import java.util.List;

import br.com.Configuracao;
import br.com.EnFequencia;
import br.com.EnFiltro;
import br.com.Resultado;

public class ProvaveisNumeros {

	private final List<Resultado> combinacoes;
	private final List<Integer> frequentes;
	private final FiltrarResultados filtraResultados;

	public ProvaveisNumeros(final Configuracao configuracao) throws IOException {
		if (configuracao == null) {
			throw new IllegalStateException("O calculo não foi configurado corretamente");
		}
		if (!configuracao.isValido()) {
			throw new IllegalStateException(configuracao.getMotivoInvalido());
		}

		// Carrega os resultados
		CarregarResultados carregarResultados = new CarregarResultados();
		if (configuracao.getCaminho() != null) {
			carregarResultados = new CarregarResultados(configuracao.getCaminho());
		}
		if (configuracao.isBaixarNovoArquivo()) {
			carregarResultados.baixar();
		}
		List<Resultado> resultados = carregarResultados.carregarResultado();

		// Filtra os resultados
		filtraResultados = new FiltrarResultados(resultados);
		EnFiltro filtro = configuracao.getFiltro();
		switch (filtro) {
		case POR_ANO:
			resultados = filtraResultados.getResultados(configuracao.getAno());
			break;
		case PERIODO_DEFINIDO:
			resultados = filtraResultados.getResultados(configuracao.getDataInicial(), configuracao.getDataFinal());
			break;
		case NUMERO_CONCURSO:
		default: // TUDO_ATE_HOJE
			resultados = filtraResultados.getResultados();
			break;
		}

		// Busca os mais/menos frequentes
		BuscaFrequencia calculaResultadoProvavel = new BuscaFrequencia(resultados);
		EnFequencia frequencia = configuracao.getFrequencia();
		if (EnFequencia.MENOS_FREQUENTES == frequencia) {
			frequentes = calculaResultadoProvavel.getMenosFrequentes();
		} else {
			frequentes = calculaResultadoProvavel.getMaisFrequentes();
		}

		// Calcular as combinações
		CalcularCombinacao calcularCombinacao = new CalcularCombinacao();
		combinacoes = calcularCombinacao.calcular(frequentes);
	}

	public List<Resultado> getResultados() throws IOException {
		return combinacoes;
	}

	public List<Integer> getFrequentes() {
		return frequentes;
	}

	public List<Integer> getListaAnos() {
		return filtraResultados.getListaAnos();
	}
}