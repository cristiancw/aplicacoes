package br.com.provaveisnumeros.parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.Resultado;
import br.com.Util;

/**
 * Faz o parser do arquivo html.
 * 
 * @author Cristian
 */
class DMegaParser {

	private static final String CHARSET = "UTF-8";
	private static final String TAG_TR = "tr";

	private static final int CONCURSO = 0;
	private static final int DATA = 1;
	private static final int PRIMEIRA_DEZENA = 2;
	private static final int SEGUNDA_DEZENA = 3;
	private static final int TERCEIRA_DEZENA = 4;
	private static final int QUARTA_DEZENA = 5;
	private static final int QUINTA_DEZENA = 6;
	private static final int SEXTA_DEZENA = 7;

	/**
	 * Carrega a lista de resultados convertendo o padrão do html adotado para a estrutura de controle interno de objetos {@link Resultado}.
	 * 
	 * @return retorna uma lista com os objetos carregados
	 */
	static List<Resultado> getResultados(File file) throws IOException {
		List<Resultado> resultados = new ArrayList<Resultado>(2000);

		Document doc = Jsoup.parse(file, CHARSET);
		Elements trs = doc.select(TAG_TR);
		boolean ignora = true;
		for (Element tr : trs) {
			if (ignora) {
				ignora = false;
				continue;
			}
			Resultado resultado = extrairResultado(tr);
			if (resultado.getNumero() > 0) {
				resultados.add(resultado);
			}
		}
		return resultados;
	}

	private static Resultado extrairResultado(Element linha) {
		Resultado resultado = new Resultado();
		int coluna = 0;
		loop: for (Element node : linha.children()) {
			String text = node.text();

			if (coluna == 0) { // testa para ver se esta na coluna com o numero do concurso
				try {
					Integer.parseInt(text);
				} catch (NumberFormatException e) {
					break loop;
				}
			}

			switch (coluna++) {
			case CONCURSO:
				resultado.setNumero(Integer.parseInt(text));
				break;
			case DATA:
				resultado.setData(Util.format(text));
				break;
			case PRIMEIRA_DEZENA:
				resultado.setPri_dezena(Integer.parseInt(text));
				break;
			case SEGUNDA_DEZENA:
				resultado.setSeg_dezena(Integer.parseInt(text));
				break;
			case TERCEIRA_DEZENA:
				resultado.setTer_dezena(Integer.parseInt(text));
				break;
			case QUARTA_DEZENA:
				resultado.setQua_dezena(Integer.parseInt(text));
				break;
			case QUINTA_DEZENA:
				resultado.setQui_dezena(Integer.parseInt(text));
				break;
			case SEXTA_DEZENA:
				resultado.setSex_dezena(Integer.parseInt(text));
				break;
			default:
				break loop;
			}
		}
		return resultado;
	}
}
