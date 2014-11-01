package br.com.provaveisnumeros;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;

public class OnClickFiltros implements OnCheckedChangeListener {

	private final LinearLayout lnlAnos;
	private final LinearLayout lnlPeriodo;
	private final LinearLayout lnlConcursos;

	public OnClickFiltros(LinearLayout lnlAnos, LinearLayout lnlPeriodo, LinearLayout lnlConcursos) {
		this.lnlAnos = lnlAnos;
		this.lnlPeriodo = lnlPeriodo;
		this.lnlConcursos = lnlConcursos;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		habilitar(lnlAnos, false);
		habilitar(lnlPeriodo, false);
		habilitar(lnlConcursos, false);

		switch (group.getCheckedRadioButtonId()) {
		case R.id.r1Ano:
			habilitar(lnlAnos, true);
			break;
		case R.id.r2Periodo:
			habilitar(lnlPeriodo, true);
			break;
		case R.id.r3Numeros:
			habilitar(lnlConcursos, true);
			break;
		default: // case R.id.r0Tudo:
			break;
		}
	}

	private void habilitar(LinearLayout linearLayout, boolean habilitar) {
		for (int i = 0; i < linearLayout.getChildCount(); i++) {
			View childAt = linearLayout.getChildAt(i);
			if (childAt instanceof EditText || childAt instanceof Spinner || childAt instanceof Button) {
				childAt.setEnabled(habilitar);
			}
		}
	}
}
