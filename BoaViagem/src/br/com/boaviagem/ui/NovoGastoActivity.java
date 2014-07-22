package br.com.boaviagem.ui;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.boaviagem.DateController;
import br.com.boaviagem.DatePickerController;
import br.com.boaviagem.R;
import br.com.database.GastoDAO;
import br.com.database.ViagemDAO;
import br.com.database.domain.EnCategoriaGasto;
import br.com.database.domain.Gasto;

public class NovoGastoActivity extends Activity {

	public static final String EXTRA_VIAGEM_ID = "viagemId";
	public static final String EXTRA_GASTO_ID = "gastoId";
	private Button btnGasData;
	private Spinner spiGasCategoria;
	private EditText edtGasValor;
	private EditText edtGasDescricao;
	private EditText edtGasLocal;

	private int ano, mes, dia;

	private ViagemDAO viagemDAO;
	private GastoDAO gastoDAO;
	private boolean gastoNovo;
	private Gasto gasto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novo_gasto);

		viagemDAO = ViagemDAO.getInstance(this);
		gastoDAO = GastoDAO.getInstance(this);

		// Spinner == combo
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categoria_gastos, android.R.layout.simple_spinner_item);
		spiGasCategoria = (Spinner) findViewById(R.id.spiGasCategoria);
		spiGasCategoria.setAdapter(adapter);

		// Calendario
		Calendar calendar = Calendar.getInstance();
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);

		btnGasData = (Button) findViewById(R.id.btnGasData);
		btnGasData.setText(DateController.format(dia, mes, ano));

		edtGasValor = (EditText) findViewById(R.id.edtGasValor);
		edtGasDescricao = (EditText) findViewById(R.id.edtGasDescricao);
		edtGasLocal = (EditText) findViewById(R.id.edtGasLocal);

		// Ou usa um id de viagem passado como parametro ou pega a ultima viagem cadastrada
		int viagemid = getIntent().getIntExtra(EXTRA_VIAGEM_ID, viagemDAO.getUltimoID());
		// Decide se é nova ou se veio de uma seleção prévia - MeusGastosActivity
		int idGastoSelecionada = getIntent().getIntExtra(EXTRA_GASTO_ID, 0);
		if (idGastoSelecionada > 0) {
			editarGasto(viagemid, idGastoSelecionada);
		} else {
			novoGasto(viagemid);
		}
	}

	private void novoGasto(int viagemid) {
		gastoNovo = true;
		gasto = new Gasto();
		gasto.setIdViagem(viagemid);
		gasto.setId(gastoDAO.getUltimoID(viagemid) + 1);
	}

	private void editarGasto(int viagemId, int idGastoSelecionada) {
		gastoNovo = false;

		gasto = gastoDAO.getGasto(viagemId, idGastoSelecionada);
		if (gasto == null) {
			throw new IllegalStateException(String.format(getString(R.string.gasto_nao_existe), idGastoSelecionada));
		}

		// Seta os valores nos componentes da tela
		spiGasCategoria.setSelection(gasto.getCategoria().getIndice());
		btnGasData.setText(DateController.format(gasto.getData()));
		edtGasValor.setText(String.valueOf(gasto.getValor()));
		edtGasDescricao.setText(gasto.getDescricao());
		edtGasLocal.setText(gasto.getLocal());
	}

	public void selecionarDataOnClick(View v) {
		showDialog(v.getId());
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == R.id.btnGasData) {
			DatePickerController controleDatePicker = new DatePickerController(btnGasData, dia, mes, ano);
			return new DatePickerDialog(this, controleDatePicker, ano, mes, dia);
		}
		return null;
	}

	public void salvarOnClick(View v) {
		gasto.setCategoria(EnCategoriaGasto.get(spiGasCategoria.getSelectedItemPosition() + 1));
		gasto.setData(DateController.format(btnGasData.getText().toString()));
		gasto.setValor(Double.parseDouble(edtGasValor.getText().toString()));
		gasto.setDescricao(edtGasDescricao.getText().toString());
		gasto.setLocal(edtGasLocal.getText().toString());

		boolean sucesso;
		if (gastoNovo) {
			sucesso = gastoDAO.inserir(gasto);
		} else {
			sucesso = gastoDAO.atualizar(gasto);
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
		menuInflater.inflate(R.menu.novo_gasto_menu, menu);
		return true;
	}
}
