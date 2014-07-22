package br.com.boaviagem.ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import br.com.boaviagem.R;

public class ConfiguracoesActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferencias);
	}
}
