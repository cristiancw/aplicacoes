package br.com;

import org.joda.time.LocalDate;

/**
 * Representa a configura��o para executar o calculo, definindo os filtros necess�rios e a frequencia escolhida.
 * 
 * @author Cristian
 * 
 */
public class Configuracao {

	private boolean baixarNovoArquivo;
	private EnFequencia frequencia;
	private EnFiltro filtro;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private int ano;
	private String motivoInvalido;
	private String caminho;

	public Configuracao() {
		baixarNovoArquivo = false;
		frequencia = EnFequencia.MAIS_FREQUENTES;
		filtro = EnFiltro.TUDO_ATE_HOJE;
		dataInicial = null;
		dataFinal = null;
		ano = 0;
	}

	public boolean isBaixarNovoArquivo() {
		return baixarNovoArquivo;
	}

	public void setBaixarNovoArquivo(boolean baixarNovoArquivo) {
		this.baixarNovoArquivo = baixarNovoArquivo;
	}

	public EnFequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(EnFequencia frequencia) {
		this.frequencia = frequencia;
	}

	public EnFiltro getFiltro() {
		return filtro;
	}

	public void setFiltro(EnFiltro filtro) {
		this.filtro = filtro;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public boolean isValido() {
		boolean isValido = true;
		motivoInvalido = null;
		if (frequencia == null) {
			isValido = false;
			motivoInvalido = "A frequ�ncia est� nula";

		} else if (ano < 0) {
			isValido = false;
			motivoInvalido = "O ano informado � negativo: " + ano;

		} else if (filtro == null) {
			isValido = false;
			motivoInvalido = "O filtro informado � nulo";

		} else if (filtro == EnFiltro.POR_ANO && ano == 0) {
			isValido = false;
			motivoInvalido = "O filtro informado est� definido para filtrar por ano mas n�o existe um ano informado";

		} else if (filtro == EnFiltro.PERIODO_DEFINIDO && (dataInicial == null || dataFinal == null)) {
			isValido = false;
			motivoInvalido = "O filtro informado est� definido por per�odo mas a data inicial ou data final n�o foi informada";

		} else if (filtro == EnFiltro.PERIODO_DEFINIDO && dataInicial.isAfter(dataFinal)) {
			isValido = false;
			motivoInvalido = "A data inicial � maior que data final";
		}
		return isValido;
	}

	public String getMotivoInvalido() {
		return motivoInvalido;
	}
}
