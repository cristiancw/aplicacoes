package br.com.provaveisnumeros;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import br.com.Resultado;
import br.com.Util;

/**
 * Realiza o filtro conforme as combinações escolhidas pelo usuário. Pode filtrar todos os resultados por um determinado período, resultados de um ano.
 * 
 * @author Cristiancw
 * 
 */
class FiltrarResultados implements Serializable {

	private static final long serialVersionUID = -8501844086303019585L;

	private final List<Resultado> lista;
	private final Map<Integer, List<Resultado>> anoLista;
	private final TreeMap<LocalDate, Resultado> dataLista;

	/**
	 * Contrutor que recebe a lista completa com todos os resultados.
	 * 
	 * @param historicoResultados
	 */
	FiltrarResultados(List<Resultado> historicoResultados) {
		lista = new ArrayList<Resultado>(historicoResultados);
		anoLista = new HashMap<Integer, List<Resultado>>();
		dataLista = new TreeMap<LocalDate, Resultado>();

		montaListaAno();
		montaListaData();
	}

	/**
	 * Com base na lista de todos os resultados separa uma lista menor com todos os anos ordenados crescentemente.
	 * 
	 * @return lista dos anos dos concursos
	 */
	List<Integer> getListaAnos() {
		List<Integer> anos = new ArrayList<Integer>(anoLista.keySet());
		Collections.sort(anos);
		Collections.reverse(anos);
		return anos;
	}

	/**
	 * Lista completa com todo resultado.
	 * 
	 * @return todos resultados dos concursos
	 */
	List<Resultado> getResultados() {
		return lista;
	}

	/**
	 * Lista dos resultados de um ano.
	 * 
	 * @param ano
	 * @return a lista dos restultados de um ano
	 */
	List<Resultado> getResultados(int ano) {
		return anoLista.get(ano);
	}

	/**
	 * Lista dos resultados entre um período de datas.
	 * 
	 * @param inicio
	 * @param fim
	 * @return lista dos resultados entre um período de datas
	 */
	List<Resultado> getResultados(LocalDate inicio, LocalDate fim) {
		return new ArrayList<Resultado>(dataLista.subMap(inicio, true, fim, true).values());
	}

	/**
	 * Lista dos resultados entre um período concursor baseado no número do concurso.
	 * 
	 * @param inicio
	 * @param fim
	 * @return lista dos resultados entre concursos
	 */
	List<Resultado> getResultados(int inicio, int fim) {
		inicio--;
		inicio = Math.max(inicio, 0); // não deixa ficar negatico
		fim = fim < inicio ? inicio : fim; // se fim for menor que inicio, considerar que o fim == inicio
		fim = Math.min(fim, lista.size()); // não deixa ficar com valor acima do tamanho da lista

		List<Resultado> resultados = new ArrayList<Resultado>(Math.max(fim - inicio, 1));
		for (int i = inicio; i < fim; i++) {
			resultados.add(lista.get(i));
		}

		return resultados;
	}

	/**
	 * Indica se naquela data deve um sorteio.
	 * 
	 * @param data
	 * @return true se teve um sorteio.
	 */
	boolean hasSorteio(LocalDate data) {
		return dataLista.containsKey(data);
	}

	/**
	 * Busca a data de um sorteio anterior a data passada, caso a data passada não caia exatamente em um dia de sorteio.
	 * 
	 * @param data
	 * @return busca o sorteio anterior
	 */
	Resultado buscaDataAnterior(LocalDate data) {
		Resultado resultado = lista.get(0);
		if (data.compareTo(resultado.getData()) < 0) {
			throw new InvalidParameterException("A data é menor que a data do primeiro concurso realizado. Dia: " + Util.format(data));
		}

		if (hasSorteio(data)) {
			return dataLista.get(data);
		}
		return buscaDataAnterior(data.minusDays(1));
	}

	/**
	 * Busca a próxima data de um sorteio, caso a data passada não caia exatamente em um dia de sorteio.
	 * 
	 * @param data
	 * @return busca o próximo sorteio
	 */
	Resultado buscaDataPosterior(LocalDate data) {
		Resultado resultado = lista.get(lista.size() - 1);
		if (data.compareTo(resultado.getData()) > 0) {
			throw new InvalidParameterException("A data é maior que a data do último concurso realizado. Dia: " + Util.format(data));
		}

		if (hasSorteio(data)) {
			return dataLista.get(data);
		}
		return buscaDataPosterior(data.plusDays(1));
	}

	private void montaListaAno() {
		for (Resultado resultado : lista) {
			int ano = resultado.getData().getYear();
			List<Resultado> listaPorAno = new ArrayList<Resultado>();

			if (anoLista.containsKey(ano)) {
				listaPorAno = anoLista.get(ano);
			} else {
				anoLista.put(ano, listaPorAno);
			}
			listaPorAno.add(resultado);
		}
	}

	private void montaListaData() {
		for (Resultado resultado : lista) {
			dataLista.put(resultado.getData(), resultado);
		}
	}
}
