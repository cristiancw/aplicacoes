package br.com.boaviagem.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import br.com.boaviagem.DateController;
import br.com.boaviagem.R;
import br.com.database.GastoDAO;
import br.com.database.ViagemDAO;
import br.com.database.domain.EnTipoViagem;
import br.com.database.domain.Viagem;

public class MinhasViagensActivity extends ListActivity implements OnItemClickListener, OnClickListener, ViewBinder {

	private static final String ID = "id";
	private static final String IMAGEM = "imagem";
	private static final String DESTINO = "destino";
	private static final String DATA = "data";
	private static final String TOTAL = "total";
	private static final String PROGRESSO = "barra progresso";

	private List<Map<String, Object>> viagens;
	private AlertDialog criaAlert;
	private AlertDialog criaAlertConfirmacao;
	private Map<String, Object> itemSelecionado;
	private Double valorLimite;
	private ViagemDAO viagemDAO;
	private GastoDAO gastoDAO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		viagemDAO = ViagemDAO.getInstance(this);
		gastoDAO = GastoDAO.getInstance(this);

		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		String string = preferences.getString("valor_limite", "0");
		valorLimite = Double.valueOf(string);

		// cria mensagens de alerta
		criaAlert = criaAlert();
		criaAlertConfirmacao = criaAlertConfirmacao();
	}

	@Override
	protected void onStart() {
		super.onStart();

		String[] de = { IMAGEM, DESTINO, DATA, TOTAL, PROGRESSO };
		int[] para = { R.id.imgMinImagem, R.id.txtMinDestino, R.id.txtMinData, R.id.txtMinValor, R.id.progressBar1 };
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, getViagens(), R.layout.minhas_viagens, de, para);
		simpleAdapter.setViewBinder(this); // faltou no livro

		setListAdapter(simpleAdapter);
		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		itemSelecionado = viagens.get(position);
		criaAlert.show();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		int id = (Integer) itemSelecionado.get(ID);

		switch (which) {
		case 0:
			Intent intent = new Intent(this, NovaViagemActivity.class);
			intent.putExtra(NovaViagemActivity.EXTRA_ID, id);
			startActivity(intent);
			break;
		case 1:
			Intent intentGasto = new Intent(this, NovoGastoActivity.class);
			intentGasto.putExtra(NovoGastoActivity.EXTRA_VIAGEM_ID, id);
			startActivity(intentGasto);
			break;
		case 2:
			Intent intentMeusGastos = new Intent(this, MeusGastosActivity.class);
			intentMeusGastos.putExtra(NovoGastoActivity.EXTRA_VIAGEM_ID, id);
			startActivity(intentMeusGastos);
			break;
		case 3:
			criaAlertConfirmacao.show();
			break;
		case DialogInterface.BUTTON_POSITIVE:
			viagens.remove(itemSelecionado);

			int idViagem = (Integer) itemSelecionado.get(ID);
			viagemDAO.apagar(idViagem);

			getListView().invalidateViews();
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			criaAlertConfirmacao.dismiss();
			break;
		}
	}

	@Override
	public boolean setViewValue(View view, Object data, String textRepresentation) {
		if (view.getId() == R.id.progressBar1) {
			Double values[] = (Double[]) data;
			ProgressBar bar = (ProgressBar) view;
			bar.setMax(values[0].intValue());
			bar.setSecondaryProgress(values[1].intValue());
			bar.setProgress(values[2].intValue());
			return true;
		}
		return false;
	}

	private List<? extends Map<String, ?>> getViagens() {
		viagens = new ArrayList<Map<String, Object>>();

		List<Viagem> todasViagens = viagemDAO.getViagens();
		for (Viagem viagem : todasViagens) {

			double totalGasto = gastoDAO.getTotalGastosPorViagem(viagem.getId());
			double alerta = viagem.getOrcamento() * valorLimite / 100;

			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put(ID, viagem.getId());
			if (EnTipoViagem.LAZER == viagem.getTipo()) {
				item.put(IMAGEM, R.drawable.lazer);
			} else {
				item.put(IMAGEM, R.drawable.negocios);
			}
			item.put(DESTINO, viagem.getDestino());
			item.put(DATA, DateController.format(viagem.getDataChegada()) + " a " + DateController.format(viagem.getDataSaida()));
			item.put(TOTAL, "R$ " + totalGasto);
			item.put(PROGRESSO, new Double[] { viagem.getOrcamento(), alerta, totalGasto });
			viagens.add(item);
		}
		return viagens;
	}

	private AlertDialog criaAlert() {
		final CharSequence[] itens = { getString(R.string.editar), getString(R.string.novo_gasto), getString(R.string.gastos_realizados), getString(R.string.remover) };

		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.opcoes);
		builder.setItems(itens, this);
		return builder.create();
	}

	private AlertDialog criaAlertConfirmacao() {
		Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.confirma_remocao);
		builder.setPositiveButton(getString(R.string.sim), this);
		builder.setNegativeButton(getString(R.string.nao), this);
		return builder.create();
	}
}
