package br.com.provaveisnumeros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import android.R.integer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import br.com.Configuracao;
import br.com.DatePickerController;
import br.com.EnFiltro;
import br.com.EnFrequencia;
import br.com.Preferencias;
import br.com.Resultado;
import br.com.Util;

public class ProvaveisNumerosActivity extends Activity {

	private ProvaveisNumeros provaveisNumeros;
	private Configuracao configuracao;
	private Preferencias preferencias;

	private RadioGroup radFiltros;
	private RadioGroup radFrequencia;
	private Spinner spiListaAnos;

	private Button btnDataInicio;
	private Button btnDataFinal;

	private EditText edtConcursoInicio;
	private EditText edtConcursoFim;

	private TextView txtResultado;
	private ImageButton imgBtnNovoNumero;
	private TextView txtErro;
	private ProgressBar prgCarregando;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_provaveis_numeros);

		inicializarComponentes();
	}

	@Override
	protected void onStart() {
		super.onStart();

		Serializable obj = getIntent().getSerializableExtra(MainActivity.PROVAVEIS_NUMEROS);
		if (obj != null && obj instanceof ProvaveisNumeros) {
			provaveisNumeros = (ProvaveisNumeros) obj;
		} else {
			Resultado resultadoFail = new Resultado();
			resultadoFail.setData(new LocalDate());
			List<Resultado> fail = new ArrayList<Resultado>(1);
			fail.add(resultadoFail);
			provaveisNumeros = new ProvaveisNumeros(fail);
		}

		String mensagem = getIntent().getExtras().getString(MainActivity.MENSAGEM, null);
		if (mensagem != null) {
			txtErro.setText(mensagem);
			if (mensagem.equals(getText(R.string.conectividade))) {
				Toast.makeText(this, R.string.sem_conexao, Toast.LENGTH_LONG).show();
			}
		}

		preferencias = new Preferencias(this);
		configuracao = preferencias.getConfiguracao();

		atualizarComponentes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.provaveis_numeros, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.atualizar_arquivo:
			finish();
			Intent intentMain = new Intent(ProvaveisNumerosActivity.this, MainActivity.class);
			intentMain.putExtra(MainActivity.ATUALIZAR, true);
			startActivity(intentMain);
			break;

		case R.id.listar_resultados:
		default:
			try {
				if (provaveisNumeros.getResultados().isEmpty()) {
					Toast.makeText(this, R.string.sem_resultado, Toast.LENGTH_LONG).show();
				} else {
					Intent intentResultados = new Intent(this, ListaResultados.class);
					intentResultados.putExtra(MainActivity.PROVAVEIS_NUMEROS, provaveisNumeros);
					startActivity(intentResultados);
				}
			} catch (IllegalStateException e) {
				Toast.makeText(this, R.string.sem_resultado, Toast.LENGTH_LONG).show();
			}
			break;
		}

		return super.onMenuItemSelected(featureId, item);
	}

	public void selecionarData(View v) {
		Button button;
		if (v.getId() == R.id.btnDataInicio) {
			button = btnDataInicio;
		} else {
			button = btnDataFinal;
		}

		LocalDate data = Util.format(button.getText().toString());
		DatePickerController controleDatePicker = new DatePickerController(button, data);
		DatePickerDialog datePickerDialog = new DatePickerDialog(this, controleDatePicker, controleDatePicker.getAno(), controleDatePicker.getMes(), controleDatePicker.getDia());
		datePickerDialog.show();
	}

	public void onClickCombinar(View v) {
		txtResultado.setText("");
		txtErro.setText("");
		imgBtnNovoNumero.setVisibility(View.VISIBLE);
		prgCarregando.setVisibility(View.INVISIBLE);

		// Atualiza as configurações
		int itemDoFiltro = radFiltros.getCheckedRadioButtonId();
		View filtroObjt = radFiltros.findViewById(itemDoFiltro);
		int filtroItem = radFiltros.indexOfChild(filtroObjt);

		int itemDoFrequencia = radFrequencia.getCheckedRadioButtonId();
		View frequenciaObjt = radFrequencia.findViewById(itemDoFrequencia);
		int frequenciaItem = radFrequencia.indexOfChild(frequenciaObjt);

		LocalDate dataInicial = Util.format(btnDataInicio.getText().toString());
		LocalDate dataFinal = Util.format(btnDataFinal.getText().toString());
		int anoSelecionado = 0;
		if (spiListaAnos.getSelectedItem() != null) {
			anoSelecionado = Integer.valueOf(spiListaAnos.getSelectedItem().toString());
		}

		String concursoInicio = edtConcursoInicio.getText().toString();
		String concursoFim = edtConcursoFim.getText().toString();

		switch (filtroItem) {
		case 0:
		default:
			configuracao.setFiltro(EnFiltro.TUDO_ATE_HOJE);
			break;
		case 1:
			configuracao.setFiltro(EnFiltro.POR_ANO);
			break;
		case 2:
			configuracao.setFiltro(EnFiltro.PERIODO_DEFINIDO);
			break;
		case 3:
			configuracao.setFiltro(EnFiltro.NUMERO_CONCURSO);
			break;
		}
		configuracao.setDataInicial(dataInicial);
		configuracao.setDataFinal(dataFinal);
		try {
			configuracao.setConcursoInicial(Integer.parseInt(concursoInicio));
		} catch (NumberFormatException e) {
			configuracao.setConcursoInicial(1);
		}
		try {
			configuracao.setConcursoFinal(Integer.parseInt(concursoFim));
		} catch (NumberFormatException e) {
			configuracao.setConcursoFinal(1);
		}
		configuracao.setAno(anoSelecionado);
		switch (frequenciaItem) {
		case 1:
			configuracao.setFrequencia(EnFrequencia.MENOS_FREQUENTES);
			break;

		case 0:
		default:
			configuracao.setFrequencia(EnFrequencia.MAIS_FREQUENTES);
			break;
		}

		new AsyncTask<Configuracao, integer, Resultado>() {

			private String erro;

			@Override
			protected Resultado doInBackground(Configuracao... params) {
				erro = null;
				try {
					provaveisNumeros.filtrar(configuracao);
				} catch (IllegalStateException e) {
					erro = e.getMessage();
					return null;
				}
				return provaveisNumeros.getResultadoAleatorio();
			}

			@Override
			protected void onPostExecute(Resultado result) {
				preferencias.atualizar(configuracao);
				imgBtnNovoNumero.setVisibility(View.VISIBLE);
				prgCarregando.setVisibility(View.INVISIBLE);
				if (result == null) {
					txtResultado.setText("");
					if (erro == null) {
						imgBtnNovoNumero.setVisibility(View.INVISIBLE);
						erro = getText(R.string.sem_resultado).toString();
					}
				} else {
					txtResultado.setText(result.getNumeros());
					txtErro.setText("");
				}
				if (erro != null) {
					txtErro.setText(erro);
				}
			}

		}.execute();
		prgCarregando.setVisibility(View.VISIBLE);
		txtErro.setText(R.string.executando);
	}

	public void onClickNovoResultado(View v) {
		Resultado resultadoAleatorio = provaveisNumeros.getResultadoAleatorio();
		if (resultadoAleatorio == null) {
			Toast.makeText(this, R.string.numeros_randomicos, Toast.LENGTH_SHORT).show();
		} else {
			txtResultado.setText(resultadoAleatorio.getNumeros());
		}
	}

	/**
	 * Carrega os componentes da UI e disponibiliza para controles internos
	 */
	private void inicializarComponentes() {
		LinearLayout lnlAnos = (LinearLayout) findViewById(R.id.lnlAnos);
		LinearLayout lnlPeriodo = (LinearLayout) findViewById(R.id.lnlPeriodo);
		LinearLayout lnlConcursos = (LinearLayout) findViewById(R.id.lnlConcursos);

		OnClickFiltros onClickFiltros = new OnClickFiltros(lnlAnos, lnlPeriodo, lnlConcursos);
		radFiltros = (RadioGroup) findViewById(R.id.radFiltros);
		radFiltros.setOnCheckedChangeListener(onClickFiltros);
		onClickFiltros.onCheckedChanged(radFiltros, 0);

		radFrequencia = (RadioGroup) findViewById(R.id.radFrequencia);

		spiListaAnos = (Spinner) findViewById(R.id.spiListaAnos);

		LocalDate data = new LocalDate();
		btnDataInicio = (Button) findViewById(R.id.btnDataInicio);
		btnDataInicio.setText(Util.format(data));

		btnDataFinal = (Button) findViewById(R.id.btnDataFinal);
		btnDataFinal.setText(Util.format(data));

		edtConcursoInicio = (EditText) findViewById(R.id.edtConcursoInicio);
		edtConcursoFim = (EditText) findViewById(R.id.edtConcursoFim);

		txtResultado = (TextView) findViewById(R.id.txtResultado);

		imgBtnNovoNumero = (ImageButton) findViewById(R.id.imgBtnNovoNumero);

		txtErro = (TextView) findViewById(R.id.txtErro);
		prgCarregando = (ProgressBar) findViewById(R.id.prgCarregando);
	}

	private void atualizarComponentes() {
		switch (configuracao.getFiltro()) {
		case TUDO_ATE_HOJE:
		default:
			radFiltros.check(R.id.r0Tudo);
			break;
		case POR_ANO:
			radFiltros.check(R.id.r1Ano);
			break;
		case PERIODO_DEFINIDO:
			radFiltros.check(R.id.r2Periodo);
			break;
		case NUMERO_CONCURSO:
			radFiltros.check(R.id.r3Numeros);
			break;
		}

		btnDataInicio.setText(Util.format(configuracao.getDataInicial()));
		btnDataFinal.setText(Util.format(configuracao.getDataFinal()));
		edtConcursoInicio.setText("" + configuracao.getConcursoInicial());
		edtConcursoFim.setText("" + configuracao.getConcursoFinal());

		ArrayAdapter<Integer> itensSpinner = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, provaveisNumeros.getListaAnos());
		spiListaAnos.setAdapter(itensSpinner);
		int indice = provaveisNumeros.getListaAnos().indexOf(configuracao.getAno());
		spiListaAnos.setSelection(indice);

		switch (configuracao.getFrequencia()) {
		case MAIS_FREQUENTES:
		default:
			radFrequencia.check(R.id.r0Mais);
			break;
		case MENOS_FREQUENTES:
			radFrequencia.check(R.id.r1Menos);
			break;
		}
	}
}
