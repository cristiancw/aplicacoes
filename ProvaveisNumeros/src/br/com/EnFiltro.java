package br.com;

import java.security.InvalidParameterException;

/**
 * Define os tipos de filtros que o usuário pode escolher.
 * 
 * @author Cristian
 * 
 */
public enum EnFiltro {
	TUDO_ATE_HOJE(0), POR_ANO(1), PERIODO_DEFINIDO(2), NUMERO_CONCURSO(3);

	private int indice;

	private EnFiltro(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}

	public static EnFiltro get(int indice) {
		for (EnFiltro enFiltro : values()) {
			if (enFiltro.getIndice() == indice) {
				return enFiltro;
			}
		}
		throw new InvalidParameterException();
	}
}
