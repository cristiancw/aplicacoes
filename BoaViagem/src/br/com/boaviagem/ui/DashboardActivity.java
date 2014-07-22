package br.com.boaviagem.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import br.com.boaviagem.R;

public class DashboardActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.dashboard_menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		finish();
		return true;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {

	}

	public void selecionarOpcaoOnClick(View v) {
		if (v instanceof TextView) {
			String botao = ((TextView) v).getText().toString();
			Toast.makeText(this, botao, Toast.LENGTH_SHORT).show();

			switch (v.getId()) {
			case R.id.txtNovoGasto:
				startActivity(new Intent(this, NovoGastoActivity.class));
				break;

			case R.id.txtNovaViagem:
				startActivity(new Intent(this, NovaViagemActivity.class));
				break;

			case R.id.txtMinhasViagens:
				startActivity(new Intent(this, MinhasViagensActivity.class));
				break;

			case R.id.txtConfig:
				startActivity(new Intent(this, ConfiguracoesActivity.class));
				break;

			default:
				break;
			}
		}
	}
}
