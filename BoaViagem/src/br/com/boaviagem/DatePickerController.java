package br.com.boaviagem;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerController implements OnDateSetListener {

	private final Button botao;
	private int dia, mes, ano;

	public DatePickerController(Button botao, int dia, int mes, int ano) {
		this.botao = botao;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		dia = dayOfMonth;
		mes = monthOfYear;
		ano = year;
		botao.setText(DateController.format(dia, mes, ano));
	}
}
