package br.com;

import java.io.Serializable;

import org.joda.time.LocalDate;

/**
 * Representa uma linha da lista de resultados do arquivo da caixa.
 * 
 * @author Cristiancw
 */
public class Resultado implements Serializable {

	private static final long serialVersionUID = 4650700045889173029L;

	private int numero;
	private LocalDate data;
	private int pri_dezena;
	private int seg_dezena;
	private int ter_dezena;
	private int qua_dezena;
	private int qui_dezena;
	private int sex_dezena;

	public Resultado() {
	}

	public Resultado(int numero, LocalDate data, int pri_dezena, int seg_dezena, int ter_dezena, int qua_dezena, int qui_dezena, int sex_dezena) {
		super();
		this.numero = numero;
		this.data = data;
		this.pri_dezena = pri_dezena;
		this.seg_dezena = seg_dezena;
		this.ter_dezena = ter_dezena;
		this.qua_dezena = qua_dezena;
		this.qui_dezena = qui_dezena;
		this.sex_dezena = sex_dezena;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int concurso) {
		numero = concurso;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPri_dezena() {
		return pri_dezena;
	}

	public void setPri_dezena(int pri_dezena) {
		this.pri_dezena = pri_dezena;
	}

	public int getSeg_dezena() {
		return seg_dezena;
	}

	public void setSeg_dezena(int seg_dezena) {
		this.seg_dezena = seg_dezena;
	}

	public int getTer_dezena() {
		return ter_dezena;
	}

	public void setTer_dezena(int ter_dezena) {
		this.ter_dezena = ter_dezena;
	}

	public int getQua_dezena() {
		return qua_dezena;
	}

	public void setQua_dezena(int qua_dezena) {
		this.qua_dezena = qua_dezena;
	}

	public int getQui_dezena() {
		return qui_dezena;
	}

	public void setQui_dezena(int qui_dezena) {
		this.qui_dezena = qui_dezena;
	}

	public int getSex_dezena() {
		return sex_dezena;
	}

	public void setSex_dezena(int sex_dezena) {
		this.sex_dezena = sex_dezena;
	}

	public String getNumeros() {
		StringBuilder builder = new StringBuilder();
		builder.append(pri_dezena);
		builder.append(", ");
		builder.append(seg_dezena);
		builder.append(", ");
		builder.append(ter_dezena);
		builder.append(", ");
		builder.append(qua_dezena);
		builder.append(", ");
		builder.append(qui_dezena);
		builder.append(", ");
		builder.append(sex_dezena);
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Número: ");
		builder.append(numero);
		builder.append(" - ");
		builder.append(data.getDayOfMonth());
		builder.append("/");
		builder.append(data.getMonthOfYear());
		builder.append("/");
		builder.append(data.getYear());
		builder.append(" = ");
		builder.append(pri_dezena);
		builder.append(",");
		builder.append(seg_dezena);
		builder.append(",");
		builder.append(ter_dezena);
		builder.append(",");
		builder.append(qua_dezena);
		builder.append(",");
		builder.append(qui_dezena);
		builder.append(",");
		builder.append(sex_dezena);
		return builder.toString();
	}

	public boolean hasNumero(int numero) {
		return pri_dezena == numero || //
				seg_dezena == numero || //
				ter_dezena == numero || //
				qua_dezena == numero || //
				qui_dezena == numero || //
				sex_dezena == numero || //
				sex_dezena == numero;
	}
}