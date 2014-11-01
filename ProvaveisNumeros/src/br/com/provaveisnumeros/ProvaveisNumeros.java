package br.com.provaveisnumeros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.Configuracao;
import br.com.EnFiltro;
import br.com.EnFrequencia;
import br.com.Resultado;

public class ProvaveisNumeros implements Serializable {

	private static final long serialVersionUID = 6723920097598600023L;

	private final FiltrarResultados filtrarResultados;
	private List<Integer> numerosFrequentes;
	private List<Resultado> combinacoes;
	private final List<Resultado> numerosRandomicos;

	public ProvaveisNumeros(List<Resultado> historicoResultados) {
		filtrarResultados = new FiltrarResultados(historicoResultados);
		numerosRandomicos = new ArrayList<Resultado>();
	}

	public void filtrar(Configuracao configuracao) {
		if (configuracao == null) {
			throw new IllegalStateException("O calculo não foi configurado corretamente.");
		}
		if (!configuracao.isValido()) {
			throw new IllegalStateException(configuracao.getMotivoInvalido());
		}

		// Filtra os resultados
		List<Resultado> resultados;
		EnFiltro filtro = configuracao.getFiltro();
		switch (filtro) {
		case POR_ANO:
			resultados = filtrarResultados.getResultados(configuracao.getAno());
			break;
		case PERIODO_DEFINIDO:
			resultados = filtrarResultados.getResultados(configuracao.getDataInicial(), configuracao.getDataFinal());
			break;
		case NUMERO_CONCURSO:
			resultados = filtrarResultados.getResultados(configuracao.getConcursoInicial(), configuracao.getConcursoFinal());
			break;
		default: // TUDO_ATE_HOJE
			resultados = filtrarResultados.getResultados();
			break;
		}

		// Busca os mais/menos frequentes
		BuscaFrequencia calculaResultadoProvavel = new BuscaFrequencia(resultados);
		EnFrequencia frequencia = configuracao.getFrequencia();
		if (EnFrequencia.MENOS_FREQUENTES == frequencia) {
			numerosFrequentes = calculaResultadoProvavel.getMenosFrequentes();
		} else {
			numerosFrequentes = calculaResultadoProvavel.getMaisFrequentes();
		}

		// Calcular as combinações
		CalcularCombinacao calcularCombinacao = new CalcularCombinacao();
		combinacoes = calcularCombinacao.calcular(numerosFrequentes);
		numerosRandomicos.clear();
	}

	public List<Resultado> getResultados() {
		if (combinacoes == null) {
			throw new IllegalStateException("É necessário carregar os dados antes de buscar sua combinação.");
		}
		return combinacoes;
	}

	public Resultado getResultadoAleatorio() {
		List<Resultado> resultados = getResultados();
		if (!resultados.isEmpty()) {
			Random random = new Random();
			int i = random.nextInt(resultados.size());
			Resultado resultado = resultados.get(i);
			if (!numerosRandomicos.contains(resultado)) {
				numerosRandomicos.add(resultado);
				return resultado;
			}

			if (resultados.size() == numerosRandomicos.size()) {
				return null; // já mostrou todas as possibilidades
			}

			return getResultadoAleatorio();
		} else {
			return null;
		}
	}

	public boolean isNumeroListadoRandomico(Resultado resultado) {
		return numerosRandomicos.contains(resultado);
	}

	public List<Integer> getNumerosFrequentes() {
		if (numerosFrequentes == null) {
			throw new IllegalStateException("É necessário carregar os dados antes de buscar sua frequencia.");
		}
		return numerosFrequentes;
	}

	public List<Integer> getListaAnos() {
		return filtrarResultados.getListaAnos();
	}
}