package br.com.database.domain;

import java.util.Date;

public class Gasto {

	private int idViagem;
	private int id;
	private EnCategoriaGasto categoria;
	private Date data;
	private double valor;
	private String descricao;
	private String local;

	public Gasto() {
	}

	public Gasto(int idViagem, int id, EnCategoriaGasto categoria, Date data, double valor, String descricao, String local) {
		super();
		this.idViagem = idViagem;
		this.id = id;
		this.categoria = categoria;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
		this.local = local;
	}

	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EnCategoriaGasto getCategoria() {
		return categoria;
	}

	public void setCategoria(EnCategoriaGasto categoria) {
		this.categoria = categoria;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
}
