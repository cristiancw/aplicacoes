package br.com;

import org.joda.time.LocalDate;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Preferencias {

	private final SharedPreferences preferencias;

	private final Configuracao configuracao;

	private static final String FILTRO = "FILTRO";
	private static final String DATA_INICIAL = "DATA_INICIAL";
	private static final String DATA_FINAL = "DATA_FINAL";
	private static final String CONCURSO_INICIAL = "CONCURSO_INICIAL";
	private static final String CONCURSO_FINAL = "CONCURSO_FINAL";
	private static final String ANO = "ANO";
	private static final String FREQUENCIA = "FREQUENCIA";

	public Preferencias(Activity activity) {
		preferencias = activity.getPreferences(Activity.MODE_PRIVATE);

		// carregar
		int indice = preferencias.getInt(FILTRO, 0);
		EnFiltro filtro = EnFiltro.get(indice);

		String hoje = Util.format(new LocalDate());
		String dataInicialSTR = preferencias.getString(DATA_INICIAL, hoje);
		LocalDate dataInicial = Util.format(dataInicialSTR);

		String dataFinalSTR = preferencias.getString(DATA_FINAL, hoje);
		LocalDate dataFinal = Util.format(dataFinalSTR);

		int concursoInicial = preferencias.getInt(CONCURSO_INICIAL, 1);
		int concursoFinal = preferencias.getInt(CONCURSO_FINAL, 1);

		int ano = preferencias.getInt(ANO, new LocalDate().getYear());

		int indiceFerq = preferencias.getInt(FREQUENCIA, 0);
		EnFrequencia frequencia = EnFrequencia.get(indiceFerq);

		// cria configuracao
		configuracao = new Configuracao();
		configuracao.setFiltro(filtro);
		configuracao.setDataInicial(dataInicial);
		configuracao.setDataFinal(dataFinal);
		configuracao.setConcursoInicial(concursoInicial);
		configuracao.setConcursoFinal(concursoFinal);
		configuracao.setAno(ano);
		configuracao.setFrequencia(frequencia);
	}

	/**
	 * Busca as prefencias já definidas pelo usuário.
	 * 
	 * @return as preferencias de configuração
	 */
	public Configuracao getConfiguracao() {
		return configuracao;
	}

	/**
	 * Atualiza as preferencias do usuário.
	 * 
	 * @param alterada
	 */
	public void atualizar(Configuracao alterada) {
		configuracao.setFiltro(alterada.getFiltro());
		configuracao.setDataInicial(alterada.getDataInicial());
		configuracao.setDataFinal(alterada.getDataFinal());
		configuracao.setConcursoInicial(alterada.getConcursoInicial());
		configuracao.setConcursoFinal(alterada.getConcursoFinal());
		configuracao.setAno(alterada.getAno());
		configuracao.setFrequencia(alterada.getFrequencia());

		atualizar();
	}

	private void atualizar() {
		Editor edit = preferencias.edit();

		edit.putInt(FILTRO, configuracao.getFiltro().getIndice());
		edit.putString(DATA_INICIAL, Util.format(configuracao.getDataInicial()));
		edit.putString(DATA_FINAL, Util.format(configuracao.getDataFinal()));
		edit.putInt(CONCURSO_INICIAL, configuracao.getConcursoInicial());
		edit.putInt(CONCURSO_FINAL, configuracao.getConcursoFinal());
		edit.putInt(ANO, configuracao.getAno());
		edit.putInt(FREQUENCIA, configuracao.getFrequencia().getIndice());

		edit.commit();
	}
}
