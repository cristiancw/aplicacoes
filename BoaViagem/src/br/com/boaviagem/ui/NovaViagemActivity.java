package br.com.boaviagem.ui;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import br.com.boaviagem.DateController;
import br.com.boaviagem.DatePickerController;
import br.com.boaviagem.R;
import br.com.database.ViagemDAO;
import br.com.database.domain.EnTipoViagem;
import br.com.database.domain.Viagem;

public class NovaViagemActivity extends Activity {

	public static String EXTRA_ID = "id";

	private int ano, mes, dia;
	private Button btnViaChegada;
	private Button btnViaSaida;
	private EditText edtViaDestino;
	private EditText edtViaQtdPessoas;
	private EditText edtViaOrcamento;
	private RadioGroup radViaTipoViagem;

	private ViagemDAO viagemDAO;
	private Viagem viagem;

	private boolean viagemNova;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_viagem);

		viagemDAO = ViagemDAO.getInstance(this);

		// Calendario
		Calendar calendar = Calendar.getInstance();
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);

		btnViaChegada = (Button) findViewById(R.id.btnViaChegada);
		btnViaChegada.setText(DateController.format(dia, mes, ano));

		btnViaSaida = (Button) findViewById(R.id.btnViaSaida);
		btnViaSaida.setText(DateController.format(dia, mes, ano));

		edtViaDestino = (EditText) findViewById(R.id.edtViaDestino);
		edtViaQtdPessoas = (EditText) findViewById(R.id.edtViaQtdPessoas);
		edtViaOrcamento = (EditText) findViewById(R.id.edtViaOrcamento);
		radViaTipoViagem = (RadioGroup) findViewById(R.id.radViaTipoViagem);

		// Decide se é nova ou se veio de uma seleção prévia - MinhasViagensActivity
		int idViagemSelecionada = getIntent().getIntExtra(EXTRA_ID, 0);
		if (idViagemSelecionada > 0) {
			editarViagem(idViagemSelecionada);
		} else {
			novaViagem();
		}
	}

	private void novaViagem() {
		viagemNova = true;
		viagem = new Viagem();
		viagem.setId(viagemDAO.getUltimoID() + 1);
	}

	private void editarViagem(int viagemId) {
		viagemNova = false;

		viagem = viagemDAO.getViagem(viagemId);
		if (viagem == null) {
			throw new IllegalStateException(String.format(getString(R.string.viagem_nao_existe), viagemId));
		}

		// Seta valores nos componentes da tela
		edtViaDestino.setText(viagem.getDestino());
		if (viagem.getTipo() == EnTipoViagem.LAZER) {
			radViaTipoViagem.check(R.id.radLazer);
		} else {
			radViaTipoViagem.check(R.id.radNegocios);
		}
		btnViaChegada.setText(DateController.format(viagem.getDataChegada()));
		btnViaSaida.setText(DateController.format(viagem.getDataSaida()));
		edtViaOrcamento.setText(String.valueOf(viagem.getOrcamento()));
		edtViaQtdPessoas.setText(String.valueOf(viagem.getQtdPessoas()));
	}

	public void selecionarDataOnClick(View v) {
		showDialog(v.getId());
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == R.id.btnViaChegada) {
			DatePickerController controleDatePicker = new DatePickerController(btnViaChegada, dia, mes, ano);
			return new DatePickerDialog(this, controleDatePicker, ano, mes, dia);
		} else if (id == R.id.btnViaSaida) {
			DatePickerController controleDatePicker = new DatePickerController(btnViaSaida, dia, mes, ano);
			return new DatePickerDialog(this, controleDatePicker, ano, mes, dia);
		}
		return null;
	}

	public void salvarOnClick(View v) {
		viagem.setDestino(edtViaDestino.getText().toString());
		viagem.setTipo(radViaTipoViagem.getCheckedRadioButtonId() == R.id.radLazer ? EnTipoViagem.LAZER : EnTipoViagem.NEGOCIOS);
		viagem.setDataChegada(DateController.format(btnViaChegada.getText().toString()));
		viagem.setDataSaida(DateController.format(btnViaSaida.getText().toString()));
		viagem.setOrcamento(Double.parseDouble(edtViaOrcamento.getText().toString()));
		viagem.setQtdPessoas(Integer.parseInt(edtViaQtdPessoas.getText().toString()));

		boolean sucesso;
		if (viagemNova) {
			sucesso = viagemDAO.inserir(viagem);
		} else {
			sucesso = viagemDAO.atualizar(viagem);
		}

		if (sucesso) {
			Toast.makeText(this, getString(R.string.registro_salvo), Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, getString(R.string.registro_nao_salvo), Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.nova_viagem_menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.novo_gasto:
			Intent intent = new Intent(this, NovoGastoActivity.class);
			startActivity(intent);
			return true;

		case R.id.remover_viagem:
			return true;

		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
