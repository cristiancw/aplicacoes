package br.com.provaveisnumeros;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import br.com.Resultado;
import br.com.provaveisnumeros.parse.CarregarResultados;

public class MainActivity extends Activity {

	public static final String PROVAVEIS_NUMEROS = "provaveisNumerosID";
	public static final String ATUALIZAR = "atualizar";
	public static final String MENSAGEM = "mensagem";

	private AsyncTask<String, Integer, List<Resultado>> asyncTask;

	private TextView txtMsgIniciar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtMsgIniciar = (TextView) findViewById(R.id.txtMsgIniciar);
	}

	@Override
	protected void onStart() {
		super.onStart();

		boolean isAtualizar = getIntent().getBooleanExtra(ATUALIZAR, false);

		inicializaProvaveisNumeros(isAtualizar);
	}

	@Override
	public void onBackPressed() {
		if (asyncTask != null) {
			asyncTask.cancel(true);
		}
		super.onBackPressed();
	}

	/**
	 * Busca os arquivos necessários para criar uma instancia de {@link ProvaveisNumeros}, com isso criar uma AsyncTask para ler os valores. Quando for carregar a primeira vez (sem cache), leva cerca
	 * de 2min, depois o tempo cai para 20seg.
	 * 
	 * @param isAtualizar
	 */
	private void inicializaProvaveisNumeros(final boolean isAtualizar) {
		final File htmlFile = getFileStreamPath(CarregarResultados.HTML_FILE); // resultados quentes
		final File zipFile = getFileStreamPath(CarregarResultados.ZIP_FILE); // zip que veio do download atualizando o arquivo html
		final File cacheDir = getCacheDir(); // diretorio de cache, já pode ser sido carregado antes
		final InputStream htmlFileInAssets;
		try {
			htmlFileInAssets = getAssets().open(CarregarResultados.HTML_FILE); // quando for a primeira vez, tem uma cópia do resultado dentro da app
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		final CarregarResultados carregarResultados = new CarregarResultados(htmlFile, htmlFileInAssets, cacheDir);

		asyncTask = new AsyncTask<String, Integer, List<Resultado>>() {
			private boolean erroConexao;

			@Override
			protected List<Resultado> doInBackground(String... params) {
				erroConexao = false;

				publishProgress(isAtualizar ? R.string.iniciando_atualizacao : R.string.iniciando);
				List<Resultado> resultados = new ArrayList<Resultado>(1);
				if (isAtualizar) {
					try {
						publishProgress(R.string.atualizando);
						carregarResultados.baixar(zipFile);
					} catch (IOException e) {
						erroConexao = true;
					}
				}

				try {
					if ((!isAtualizar || erroConexao) && carregarResultados.isCached()) {
						publishProgress(R.string.carregando_com_cache);
						resultados = carregarResultados.carregarCache();
					} else {
						if (!carregarResultados.isIniciado()) {
							publishProgress(R.string.carregando_pela_primeira_vez);
							carregarResultados.copiarArquivoHtml();
						}
						publishProgress(R.string.carregando_sem_cache);
						resultados = carregarResultados.carregarResultado();
						publishProgress(R.string.criando_cache);
						carregarResultados.criarCache(resultados);
					}
				} catch (IOException | ClassNotFoundException e) {
					publishProgress(R.string.conectividade);
				}
				return resultados;
			}

			@Override
			protected void onProgressUpdate(Integer... values) {
				super.onProgressUpdate(values);
				txtMsgIniciar.setText(values[0]);
			}

			@Override
			protected void onPostExecute(List<Resultado> result) {
				ProvaveisNumeros provaveisNumeros = new ProvaveisNumeros(result);
				Intent intentProvaveisNumeros = new Intent(MainActivity.this, ProvaveisNumerosActivity.class);
				intentProvaveisNumeros.putExtra(PROVAVEIS_NUMEROS, provaveisNumeros);
				if (erroConexao) {
					intentProvaveisNumeros.putExtra(MENSAGEM, getText(R.string.conectividade));
				}
				startActivity(intentProvaveisNumeros);
				finish();
			}
		};
		asyncTask.execute();
	}
}
