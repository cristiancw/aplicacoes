package br.com.provaveisnumeros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import br.com.Resultado;

public class ListaResultados extends ListActivity {

	private static final String RESULTADO = "Resultado";
	private static final String LISTADO = "Listado";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onStart() {
		super.onStart();

		Serializable obj = getIntent().getSerializableExtra(MainActivity.PROVAVEIS_NUMEROS);
		ProvaveisNumeros provaveisNumeros;
		if (obj != null && obj instanceof ProvaveisNumeros) {
			provaveisNumeros = (ProvaveisNumeros) obj;
		} else {
			Resultado resultadoFail = new Resultado();
			resultadoFail.setData(new LocalDate());
			List<Resultado> fail = new ArrayList<Resultado>(1);
			fail.add(resultadoFail);
			provaveisNumeros = new ProvaveisNumeros(fail);
		}

		String[] de = { RESULTADO };
		int[] para = { R.id.txtResultados };
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(provaveisNumeros), R.layout.activity_lista_resultados, de, para);
		setListAdapter(simpleAdapter);
	}

	private List<? extends Map<String, String>> getData(ProvaveisNumeros provaveisNumeros) {
		List<Map<String, String>> listaResultados = new ArrayList<Map<String, String>>();
		for (Resultado resultado : provaveisNumeros.getResultados()) {
			Map<String, String> item = new HashMap<String, String>();
			item.put(RESULTADO, resultado.getNumeros());
			item.put(LISTADO, String.valueOf(provaveisNumeros.isNumeroListadoRandomico(resultado)));
			listaResultados.add(item);
		}
		return listaResultados;
	}
}
