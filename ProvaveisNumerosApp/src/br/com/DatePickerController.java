package br.com;

import org.joda.time.LocalDate;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerController implements OnDateSetListener {

	private final Button botao;
	private int dia, mes, ano;

	public DatePickerController(Button botao, LocalDate data) {
		this.botao = botao;
		dia = data.getDayOfMonth();
		mes = data.getMonthOfYear() - 1;
		ano = data.getYear();
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		dia = dayOfMonth;
		mes = monthOfYear + 1;
		ano = year;
		botao.setText(Util.format(dia, mes, ano));
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
}
