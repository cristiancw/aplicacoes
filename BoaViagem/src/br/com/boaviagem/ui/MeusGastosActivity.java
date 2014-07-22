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
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;
import br.com.boaviagem.R;
import br.com.database.GastoDAO;
import br.com.database.ViagemDAO;
import br.com.database.domain.Gasto;

public class MeusGastosActivity extends ListActivity implements OnItemClickListener, OnClickListener {

	private static final String DATA = "data";
	private static final String DESCRICAO = "descricao";
	private static final String TOTAL = "total";
	private static final String CATEGORIA = "categoria";
	private static final String ID = "id";
	private static final String LOCAL = "local";

	private String dataAnterior = "";
	private int viagemid;

	private AlertDialog criaAlert;
	private List<Map<String, Object>> gastos;
	private Map<String, Object> itemSelecionado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ViagemDAO viagemDAO = ViagemDAO.getInstance(this);
		viagemid = getIntent().getIntExtra(NovoGastoActivity.EXTRA_VIAGEM_ID, viagemDAO.getUltimoID());

		// cria mensagens de alerta
		criaAlert = criaAlert();

		// registro de menu de contexto
		registerForContextMenu(getListView());
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		String[] de = { DATA, DESCRICAO, TOTAL, CATEGORIA };
		int[] para = { R.id.txtMeuData, R.id.txtMeuDescricao, R.id.txtMeuValor, R.id.linMeuCategoria };

		SimpleAdapter simpleAdapter = new SimpleAdapter(this, getGastos(), R.layout.meus_gastos, de, para);
		simpleAdapter.setViewBinder(new GastoViewBinder());

		setListAdapter(simpleAdapter);
		getListView().setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		itemSelecionado = gastos.get(position);

		StringBuilder builder = new StringBuilder();
		builder.append("Gasto selecionado: ");
		builder.append(itemSelecionado.get(DESCRICAO));
		Toast.makeText(this, builder, Toast.LENGTH_SHORT).show();

		criaAlert.show();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		int id = (Integer) itemSelecionado.get(ID);

		switch (which) {
		case 0:
			Intent intentGasto = new Intent(this, NovoGastoActivity.class);
			intentGasto.putExtra(NovoGastoActivity.EXTRA_VIAGEM_ID, viagemid);
			intentGasto.putExtra(NovoGastoActivity.EXTRA_GASTO_ID, id);
			startActivity(intentGasto);
			break;
		case 1:
			GastoDAO.getInstance(this).apagar(viagemid, id);
			gastos.remove(itemSelecionado);
			getListView().invalidateViews();
			dataAnterior = "";
			break;
		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.novo_gasto_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.remover) {
			AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
			gastos.remove(menuInfo.position);
			getListView().invalidateViews();
			dataAnterior = "";
		}
		return super.onContextItemSelected(item);
	}

	private List<? extends Map<String, ?>> getGastos() {
		gastos = new ArrayList<Map<String, Object>>();

		List<Gasto> gastosPorViagem = GastoDAO.getInstance(this).getGastosPorViagem(viagemid);
		for (Gasto gasto : gastosPorViagem) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put(ID, gasto.getId());
			item.put(DATA, gasto.getData());
			item.put(DESCRICAO, gasto.getDescricao());
			item.put(TOTAL, "R$ " + gasto.getValor());
			item.put(LOCAL, gasto.getLocal());

			if ("Alimentação".equals(gasto.getCategoria())) {
				item.put(CATEGORIA, R.color.gastos_alimentacao);
			} else if ("Combustível".equals(gasto.getCategoria())) {
				item.put(CATEGORIA, R.color.gastos_combustivel);
			} else if ("Transporte".equals(gasto.getCategoria())) {
				item.put(CATEGORIA, R.color.gastos_transporte);
			} else if ("Hospedagem".equals(gasto.getCategoria())) {
				item.put(CATEGORIA, R.color.gastos_hospedagem);
			} else {
				item.put(CATEGORIA, R.color.gastos_outros);
			}
			gastos.add(item);
		}

		return gastos;
	}

	private AlertDialog criaAlert() {
		final CharSequence[] itens = { getString(R.string.editar), getString(R.string.remover) };

		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.opcoes);
		builder.setItems(itens, this);
		return builder.create();
	}

	class GastoViewBinder implements ViewBinder {

		@Override
		public boolean setViewValue(View view, Object data, String textRepresentation) {
			if (view.getId() == R.id.txtMeuData) {
				if (!dataAnterior.equals(data)) {
					TextView textView = (TextView) view;
					textView.setText(textRepresentation);
					dataAnterior = textRepresentation;
					view.setVisibility(View.VISIBLE);
				} else {
					view.setVisibility(View.GONE);
				}
				return true;
			}

			if (view.getId() == R.id.linMeuCategoria) {
				Integer id = (Integer) data;
				view.setBackgroundColor(getResources().getColor(id));
				return true;
			}
			return false;
		}
	}
}
