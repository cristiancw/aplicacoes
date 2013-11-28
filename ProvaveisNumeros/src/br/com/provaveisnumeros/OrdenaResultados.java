package br.com.provaveisnumeros;

import java.util.Comparator;

import br.com.Resultado;

class OrdenaResultados implements Comparator<Resultado> {

	@Override
	public int compare(Resultado o1, Resultado o2) {
		if (o1.getPri_dezena() == o2.getPri_dezena()) {
			if (o1.getSeg_dezena() == o2.getSeg_dezena()) {
				if (o1.getTer_dezena() == o2.getTer_dezena()) {
					if (o1.getQua_dezena() == o2.getQua_dezena()) {
						if (o1.getQui_dezena() == o2.getQui_dezena()) {
							return Integer.valueOf(o1.getSex_dezena()).compareTo(Integer.valueOf(o2.getSex_dezena()));
						}
						return Integer.valueOf(o1.getQui_dezena()).compareTo(Integer.valueOf(o2.getQui_dezena()));
					}
					return Integer.valueOf(o1.getQua_dezena()).compareTo(Integer.valueOf(o2.getQua_dezena()));
				}
				return Integer.valueOf(o1.getTer_dezena()).compareTo(Integer.valueOf(o2.getTer_dezena()));
			}
			return Integer.valueOf(o1.getSeg_dezena()).compareTo(Integer.valueOf(o2.getSeg_dezena()));
		}
		return Integer.valueOf(o1.getPri_dezena()).compareTo(Integer.valueOf(o2.getPri_dezena()));
	}
}
