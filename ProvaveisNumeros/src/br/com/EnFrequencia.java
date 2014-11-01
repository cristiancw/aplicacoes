package br.com;

import java.security.InvalidParameterException;

/**
 * Define os tipos de frequencia que o usuário pode escolher.
 * 
 * @author Cristian
 * 
 */
public enum EnFrequencia {
	MAIS_FREQUENTES(0), MENOS_FREQUENTES(1);

	private int indice;

	private EnFrequencia(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}

	public static EnFrequencia get(int indice) {
		for (EnFrequencia enFrequencia : values()) {
			if (enFrequencia.getIndice() == indice) {
				return enFrequencia;
			}
		}
		throw new InvalidParameterException();
	}
}
