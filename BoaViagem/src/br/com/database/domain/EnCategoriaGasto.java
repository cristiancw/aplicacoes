package br.com.database.domain;

import android.content.Context;
import br.com.boaviagem.R;

public enum EnCategoriaGasto {

	ALIMENTACAO(1, 0), //
	COMBUSTIVEL(2, 1), //
	TRANSPORTE(3, 2), //
	HOSPEDAGEM(4, 3), //
	OUTROS(5, 4);

	private int id;
	private int indice;

	private EnCategoriaGasto(int id, int indice) {
		this.id = id;
		this.indice = indice;
	}

	public int getId() {
		return id;
	}

	public int getIndice() {
		return indice;
	}

	public String getDescricao(Context context) {
		return context.getResources().getStringArray(R.array.categoria_gastos)[indice];
	}

	public static EnCategoriaGasto get(int i) {
		switch (i) {
		case 1:
			return ALIMENTACAO;
		case 2:
			return COMBUSTIVEL;
		case 3:
			return TRANSPORTE;
		case 4:
			return HOSPEDAGEM;
		case 5:
			return OUTROS;
		default:
			throw new IllegalArgumentException("O tipo de categoria passada não existe: " + i);
		}
	}
}
