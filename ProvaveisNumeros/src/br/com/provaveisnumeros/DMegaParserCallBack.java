package br.com.provaveisnumeros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import org.joda.time.LocalDate;

/**
 * Faz o parser do arquivo html.
 * 
 * @author Cristiancw
 * 
 */
class DMegaParserCallBack extends HTMLEditorKit.ParserCallback {

	private Resultado atual;
	private int colunaAtual = -1;
	private List<Resultado> resultados;

	private static final int CONCURSO = 0;
	private static final int DATA = 1;
	private static final int PRIMEIRA_DEZENA = 2;
	private static final int SEGUNDA_DEZENA = 3;
	private static final int TERCEIRA_DEZENA = 4;
	private static final int QUARTA_DEZENA = 5;
	private static final int QUINTA_DEZENA = 6;
	private static final int SEXTA_DEZENA = 7;

	@Override
	public void handleText(char[] data, int pos) {
		String valor = new String(data);
		if ("Concurso".equals(valor)) { // esta no cabeçalho, pode eliminar o objeto criado
			atual = null;
			getResultados().clear();
		}

		switch (colunaAtual) {
		case CONCURSO:
			atual.setNumero(Integer.parseInt(valor));
			break;
		case DATA:
			atual.setData(getData(valor));
			break;
		case PRIMEIRA_DEZENA:
			atual.setPri_dezena(Integer.parseInt(valor));
			break;
		case SEGUNDA_DEZENA:
			atual.setSeg_dezena(Integer.parseInt(valor));
			break;
		case TERCEIRA_DEZENA:
			atual.setTer_dezena(Integer.parseInt(valor));
			break;
		case QUARTA_DEZENA:
			atual.setQua_dezena(Integer.parseInt(valor));
			break;
		case QUINTA_DEZENA:
			atual.setQui_dezena(Integer.parseInt(valor));
			break;
		case SEXTA_DEZENA:
			atual.setSex_dezena(Integer.parseInt(valor));
			break;
		default:
			break;
		}
	}

	@Override
	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		if (t == HTML.Tag.TR) {
			colunaAtual = -1;
			atual = new Resultado();
			getResultados().add(atual);
		} else if (t == HTML.Tag.TD) {
			colunaAtual++;
		}
	}

	/**
	 * Carrega a lista de resultados e devolve em forma de objeto para facil manipulação.
	 * 
	 * @return lista de resultados
	 */
	List<Resultado> getResultados() {
		if (resultados == null) {
			resultados = new ArrayList<Resultado>();
		}
		return resultados;
	}

	private LocalDate getData(String data) {
		String[] split = data.split("/");

		int ano = Integer.parseInt(split[2]);
		int mes = Integer.parseInt(split[1]);
		int dia = Integer.parseInt(split[0]);

		return new LocalDate(ano, mes, dia);
	}
}