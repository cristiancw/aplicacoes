package br.com;

import org.joda.time.LocalDate;

/**
 * Representa a configura��o para executar o calculo, definindo os filtros necess�rios e a frequencia escolhida.
 * 
 * @author Cristian
 * 
 */
public class Configuracao {

	private EnFrequencia frequencia;
	private EnFiltro filtro;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private int concursoInicial;
	private int concursoFinal;
	private int ano;
	private String motivoInvalido;

	public Configuracao() {
		frequencia = EnFrequencia.MAIS_FREQUENTES;
		filtro = EnFiltro.TUDO_ATE_HOJE;
		dataInicial = null;
		dataFinal = null;
		ano = 0;
	}

	public EnFrequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(EnFrequencia frequencia) {
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

	public int getConcursoInicial() {
		return concursoInicial;
	}

	public void setConcursoInicial(int concursoInicial) {
		this.concursoInicial = concursoInicial;
	}

	public int getConcursoFinal() {
		return concursoFinal;
	}

	public void setConcursoFinal(int concursoFinal) {
		this.concursoFinal = concursoFinal;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isValido() {
		boolean isValido = true;
		motivoInvalido = null;
		if (frequencia == null) {
			isValido = false;
			motivoInvalido = "A frequ�ncia est� nula.";

		} else if (ano < 0) {
			isValido = false;
			motivoInvalido = "O ano informado � negativo: " + ano + ".";

		} else if (filtro == null) {
			isValido = false;
			motivoInvalido = "O filtro informado � nulo.";

		} else if (filtro == EnFiltro.POR_ANO && ano == 0) {
			isValido = false;
			motivoInvalido = "O filtro informado est� definido para filtrar por ano mas n�o existe um ano informado.";

		} else if (filtro == EnFiltro.PERIODO_DEFINIDO && (dataInicial == null || dataFinal == null)) {
			isValido = false;
			motivoInvalido = "O filtro informado est� definido por per�odo mas a data inicial ou data final n�o foi informada.";

		} else if (filtro == EnFiltro.PERIODO_DEFINIDO && dataInicial.isAfter(dataFinal)) {
			isValido = false;
			motivoInvalido = "A data inicial � maior que data final.";

		} else if (filtro == EnFiltro.NUMERO_CONCURSO && (concursoInicial < 0 || concursoFinal < 0)) {
			isValido = false;
			motivoInvalido = "Os n�meros do intervalo entre concursos n�o pode ser negativo.";

		} else if (filtro == EnFiltro.NUMERO_CONCURSO && concursoFinal < concursoInicial) {
			isValido = false;
			motivoInvalido = "O n�mero inicial do concurso n�o pode ser maior que o n�mero fina.";
		}
		return isValido;
	}

	public String getMotivoInvalido() {
		return motivoInvalido;
	}
}
