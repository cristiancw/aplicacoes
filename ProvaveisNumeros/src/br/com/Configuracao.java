package br.com;

import org.joda.time.LocalDate;

/**
 * Representa a configuração para executar o calculo, definindo os filtros necessários e a frequencia escolhida.
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
}
