package br.com;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Utilitarios.
 * 
 * @author Cristiancw
 * 
 */
public class Util {

	private final static String DIA_MES_ANO_4 = "dd/MM/yyyy";

	/**
	 * Transforma um objeto LocalDate em uma String amigavél com o padrão comum. Ex.: 01/01/2001.
	 * 
	 * @param data
	 * @return uma string com a data formatada
	 */
	public static String format(LocalDate data) {
		DateTimeFormatter format = DateTimeFormat.forPattern(DIA_MES_ANO_4);
		return data.toString(format);
	}
}
