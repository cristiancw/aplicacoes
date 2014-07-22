package br.com.database.domain;

import android.content.Context;
import br.com.boaviagem.R;

public enum EnTipoViagem {

	LAZER(1), //
	NEGOCIOS(2);

	private int id;

	private EnTipoViagem(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getDescricao(Context context) {
		if (this == LAZER) {
			return context.getResources().getString(R.string.lazer);
		} else if (this == NEGOCIOS) {
			return context.getResources().getString(R.string.negocios);
		}
		throw new IllegalArgumentException("O tipo de viagem não existe");
	}

	public static EnTipoViagem get(int i) {
		switch (i) {
		case 1:
			return LAZER;
		case 2:
			return NEGOCIOS;
		default:
			throw new IllegalArgumentException("O tipo de viagem passada não existe: " + i);
		}
	}
}
