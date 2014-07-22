package br.com.database.domain;

import java.util.Date;

public class Viagem {

	public static String ID = "_id";
	public static String DESTINO = "destino";
	public static String TIPO = "tipo";
	public static String DATA_CHEGADA = "datachegada";
	public static String DATA_SAIDA = "datasaida";
	public static String ORCAMENTO = "orcamento";
	public static String QTD_PESSOAS = "qtdpessoas";

	private int id;
	private String destino;
	private EnTipoViagem tipo;
	private Date dataChegada;
	private Date dataSaida;
	private double orcamento;
	private int qtdPessoas;

	public Viagem() {
	}

	public Viagem(int id, String destino, EnTipoViagem tipo, Date dataChegada, Date dataSaida, double orcamento, int qtdPessoas) {
		super();
		this.id = id;
		this.destino = destino;
		this.tipo = tipo;
		this.dataChegada = dataChegada;
		this.dataSaida = dataSaida;
		this.orcamento = orcamento;
		this.qtdPessoas = qtdPessoas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public EnTipoViagem getTipo() {
		return tipo;
	}

	public void setTipo(EnTipoViagem tipo) {
		this.tipo = tipo;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
}
