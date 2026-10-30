package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Vínculo de um profissional com uma unidade (Cadastros · Regra 8).
 */
@Entity
@Table(name = "vinculo")
public class Vinculo extends EntidadeInativavel {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profissional_id", nullable = false)
	private Profissional profissional;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade_id", nullable = false)
	private Unidade unidade;

	@Column(name = "carga_horaria_semanal", nullable = false, precision = 5, scale = 2)
	private BigDecimal cargaHorariaSemanal;

	@Column(name = "inicio_vigencia", nullable = false)
	private LocalDate inicioVigencia;

	@Column(name = "fim_vigencia")
	private LocalDate fimVigencia;

	protected Vinculo() {
	}

	public Vinculo(
			Profissional profissional,
			Unidade unidade,
			BigDecimal cargaHorariaSemanal,
			LocalDate inicioVigencia) {
		this.profissional = profissional;
		this.unidade = unidade;
		this.cargaHorariaSemanal = cargaHorariaSemanal;
		this.inicioVigencia = inicioVigencia;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public BigDecimal getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}

	public LocalDate getInicioVigencia() {
		return inicioVigencia;
	}

	public LocalDate getFimVigencia() {
		return fimVigencia;
	}

}
