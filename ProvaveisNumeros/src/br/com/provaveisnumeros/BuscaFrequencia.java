package br.com.provaveisnumeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.Resultado;

/**
 * Com base em uma lista de resultados préviamente filtrada separa os 6 resultados que mais apareceram e lista os valores que apareceram como sendo os próximos prováveis.
 * 
 * @author Cristiancw
 * 
 */
class BuscaFrequencia {

	private final int[] contResultado;
	private static final int TAMANHO_LISTA = 61; // posição 0 sempre deve ser 0
	private static final int ITENS = 6;

	/**
	 * Recebe uma lista de resultados préviamente filtrados.
	 * 
	 * @param resultados
	 */
	BuscaFrequencia(List<Resultado> resultados) {
		contResultado = montaContadorResultados(resultados);
	}

	/**
	 * Dentre os valores filtrados passados no construtor, busca os números que mais aparecem. Caso os valores se repitam os resultados repetidos serão retornados.
	 * 
	 * @return lista de valores que mais aparecem
	 */
	List<Integer> getMaisFrequentes() {
		// Duplica a lista original e ordena ela
		int[] listaOrdenada = new int[TAMANHO_LISTA];
		for (int i = 0; i < listaOrdenada.length; i++) {
			listaOrdenada[i] = contResultado[i];
		}
		Arrays.sort(listaOrdenada);

		// busca os 6 mais repetidos
		int[] mais = new int[ITENS];
		mais[0] = listaOrdenada[TAMANHO_LISTA - 1];
		mais[1] = listaOrdenada[TAMANHO_LISTA - 2];
		mais[2] = listaOrdenada[TAMANHO_LISTA - 3];
		mais[3] = listaOrdenada[TAMANHO_LISTA - 4];
		mais[4] = listaOrdenada[TAMANHO_LISTA - 5];
		mais[5] = listaOrdenada[TAMANHO_LISTA - 6];

		// busca suas posições na lista original
		List<Integer> maisFrequentes = new ArrayList<Integer>();
		for (int i = 0; i < contResultado.length; i++) {
			if (contResultado[i] == mais[0] && mais[0] > 0) {
				maisFrequentes.add(i);
			} else if (contResultado[i] == mais[1] && mais[1] > 0) {
				maisFrequentes.add(i);
			} else if (contResultado[i] == mais[2] && mais[2] > 0) {
				maisFrequentes.add(i);
			} else if (contResultado[i] == mais[3] && mais[3] > 0) {
				maisFrequentes.add(i);
			} else if (contResultado[i] == mais[4] && mais[4] > 0) {
				maisFrequentes.add(i);
			} else if (contResultado[i] == mais[5] && mais[5] > 0) {
				maisFrequentes.add(i);
			}
		}

		return maisFrequentes;
	}

	/**
	 * Dentre os valores filtrados passados no construtor, busca os números que menos aparecem. Caso os valores se repitam os resultados repetidos serão retornados.
	 * 
	 * @return lista de valores que menos aparecem
	 */
	List<Integer> getMenosFrequentes() {
		// Duplica a lista original e ordena ela
		int[] listaOrdenada = new int[TAMANHO_LISTA];
		for (int i = 0; i < listaOrdenada.length; i++) {
			listaOrdenada[i] = contResultado[i];
		}
		Arrays.sort(listaOrdenada);

		// busca a primeira posição da lista com números maires que 0
		int pos = 0;
		for (; pos < listaOrdenada.length; pos++) {
			if (listaOrdenada[pos] > 0) {
				break;
			}
		}

		// Quando não passou nada pelo filtro, por exemplo números de consursos que não existem ainda, datas que não existem ainda.
		if (pos >= listaOrdenada.length) {
			pos = 0;
		}

		// busca os 6 mais repetidos
		int[] mais = new int[ITENS];
		mais[0] = listaOrdenada[pos++];
		mais[1] = listaOrdenada[pos++];
		mais[2] = listaOrdenada[pos++];
		mais[3] = listaOrdenada[pos++];
		mais[4] = listaOrdenada[pos++];
		mais[5] = listaOrdenada[pos++];

		// busca suas posições na lista original
		List<Integer> menosFrequentes = new ArrayList<Integer>();
		for (int i = 0; i < contResultado.length; i++) {
			if (contResultado[i] == mais[0] && mais[0] > 0) {
				menosFrequentes.add(i);
			} else if (contResultado[i] == mais[1] && mais[1] > 0) {
				menosFrequentes.add(i);
			} else if (contResultado[i] == mais[2] && mais[2] > 0) {
				menosFrequentes.add(i);
			} else if (contResultado[i] == mais[3] && mais[3] > 0) {
				menosFrequentes.add(i);
			} else if (contResultado[i] == mais[4] && mais[4] > 0) {
				menosFrequentes.add(i);
			} else if (contResultado[i] == mais[5] && mais[5] > 0) {
				menosFrequentes.add(i);
			}
		}

		return menosFrequentes;
	}

	/**
	 * Monta um array onde a posição dele é uma das 60 possibilidades do jogo e em cada posição a quantidade de vezes que o valor surgiu.
	 * 
	 * @param resultados
	 * @return array de 60 posições com o valore de vezes em que cada número apareceu.
	 */
	private int[] montaContadorResultados(List<Resultado> resultados) {
		int[] contador = new int[TAMANHO_LISTA];
		Arrays.fill(contador, 0);
		for (Resultado resultado : resultados) {
			contador[resultado.getPri_dezena()]++;
			contador[resultado.getSeg_dezena()]++;
			contador[resultado.getTer_dezena()]++;
			contador[resultado.getQua_dezena()]++;
			contador[resultado.getQui_dezena()]++;
			contador[resultado.getSex_dezena()]++;
		}
		return contador;
	}
}
