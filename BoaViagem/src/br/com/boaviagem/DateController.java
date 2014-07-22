package br.com.boaviagem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateController {

	private static final String DIA_MES_ANO_4 = "dd/MM/yyyy";

	public static String format(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DIA_MES_ANO_4, Locale.getDefault());
		return dateFormat.format(date);
	}

	public static String format(long date) {
		return format(new Date(date));
	}

	public static String format(int dia, int mes, int ano) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.MONTH, mes - 1);
		calendar.set(Calendar.YEAR, ano);
		return format(calendar.getTime());
	}

	public static Date format(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DIA_MES_ANO_4, Locale.getDefault());
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
