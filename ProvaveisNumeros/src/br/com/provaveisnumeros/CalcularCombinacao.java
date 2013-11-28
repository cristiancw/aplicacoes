package br.com.provaveisnumeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.Resultado;

/**
 * Com a lista de números possivéis calcula todas a combinações de resultados que eles podem gerar.
 * 
 * @author Cristiancw
 * 
 */
class CalcularCombinacao {

	private final OrdenaResultados ordenaResultados;

	CalcularCombinacao() {
		ordenaResultados = new OrdenaResultados();
	}

	/**
	 * Calcula as combinações possiveis utilizando os números passados.
	 * 
	 * @param frequentes
	 * @return lista de possiveis resultados.
	 */
	List<Resultado> calcular(List<Integer> frequentes) {
		List<Resultado> combinacoes = new ArrayList<Resultado>();

		for (int pri_dezena : frequentes) {
			Resultado possivel = new Resultado();
			possivel.setNumero(0);
			possivel.setData(new LocalDate());
			possivel.setPri_dezena(pri_dezena);
			for (int seg_dezena : frequentes) {
				if (!possivel.hasNumero(seg_dezena)) {
					possivel.setSeg_dezena(seg_dezena);
					for (int ter_dezena : frequentes) {
						if (!possivel.hasNumero(ter_dezena)) {
							possivel.setTer_dezena(ter_dezena);
							for (int qua_dezena : frequentes) {
								if (!possivel.hasNumero(qua_dezena)) {
									possivel.setQua_dezena(qua_dezena);
									for (int qui_dezena : frequentes) {
										if (!possivel.hasNumero(qui_dezena)) {
											possivel.setQui_dezena(qui_dezena);
											for (int sex_dezena : frequentes) {
												if (!possivel.hasNumero(sex_dezena)) {
													possivel.setSex_dezena(sex_dezena);
													if (!jaExiste(combinacoes, possivel)) {
														combinacoes.add(possivel);
														Resultado possivel_aux = new Resultado();
														possivel_aux.setNumero(possivel.getNumero());
														possivel_aux.setData(possivel.getData());
														possivel_aux.setPri_dezena(possivel.getPri_dezena());
														possivel_aux.setSeg_dezena(possivel.getSeg_dezena());
														possivel_aux.setTer_dezena(possivel.getTer_dezena());
														possivel_aux.setQua_dezena(possivel.getQua_dezena());
														possivel_aux.setQui_dezena(possivel.getQui_dezena());
														possivel_aux.setSex_dezena(possivel.getSex_dezena());
														possivel = possivel_aux;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		Collections.sort(combinacoes, ordenaResultados);
		return combinacoes;
	}

	private boolean jaExiste(List<Resultado> combinacoes, Resultado possivel) {
		int[] possiveis = { possivel.getPri_dezena(), possivel.getSeg_dezena(), possivel.getTer_dezena(), possivel.getQua_dezena(), possivel.getQui_dezena(), possivel.getSex_dezena() };
		Arrays.sort(possiveis);
		boolean existe = false;
		for (Resultado resultado : combinacoes) {
			int[] incluidos = { resultado.getPri_dezena(), resultado.getSeg_dezena(), resultado.getTer_dezena(), resultado.getQua_dezena(), resultado.getQui_dezena(), resultado.getSex_dezena() };
			Arrays.sort(incluidos);
			existe = possiveis[0] == incluidos[0] && //
					possiveis[1] == incluidos[1] && //
					possiveis[2] == incluidos[2] &&	//
					possiveis[3] == incluidos[3] &&	//
					possiveis[4] == incluidos[4] &&	//
					possiveis[5] == incluidos[5];
			if (existe) {
				return existe;
			}
		}

		return false;
	}
}
