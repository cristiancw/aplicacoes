package br.com.boaviagem.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import br.com.boaviagem.PreferenceController;
import br.com.boaviagem.R;

public class LoginActivity extends Activity {

	private EditText edtUsuario;
	private EditText edtSenha;
	private CheckBox chkManterLogado;

	private PreferenceController preferenceController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		edtUsuario = (EditText) findViewById(R.id.edtUsuario);
		edtSenha = (EditText) findViewById(R.id.edtSenha);
		chkManterLogado = (CheckBox) findViewById(R.id.chkManterLogado);

		preferenceController = new PreferenceController(this);
		String user = preferenceController.getUser();
		String senha = preferenceController.getPass();
		boolean isConecatdo = preferenceController.isKeepLoged();

		if (user != null && senha != null && isConecatdo) {
			edtUsuario.setText(user);
			edtSenha.setText(senha);
			chkManterLogado.setChecked(isConecatdo);
		}

	}

	public void entrarOnClick(View v) {
		if ("1".equals(edtUsuario.getText().toString()) && "1".equals(edtSenha.getText().toString())) {
			preferenceController.setKeepLoged(chkManterLogado.isChecked());
			preferenceController.setUser(edtUsuario.getText().toString());
			preferenceController.setPass(edtSenha.getText().toString());

			Intent intent = new Intent(this, DashboardActivity.class);
			startActivity(intent);
		} else {
			String erroAutenticacao = getResources().getString(R.string.erro_autenticacao);
			Toast toast = Toast.makeText(this, erroAutenticacao, Toast.LENGTH_SHORT);
			toast.show();
		}
	}
}
