package br.com.basetech.ubiq.api.indicador.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Resultado de um indicador por unidade e dia ou mês (Indicadores · Regras 4 e 5).
 */
@Entity
@Table(name = "resultado_indicador", uniqueConstraints = {
		@UniqueConstraint(name = "uk_resultado_indicador", columnNames = {"unidade_id", "codigo_indicador", "data", "periodo"})
})
public class ResultadoIndicador extends EntidadeOperacional {

	@Column(name = "codigo_indicador", nullable = false)
	private String codigoIndicador;

	@Column(name = "data", nullable = false)
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	@Column(name = "periodo", nullable = false, length = 40)
	private Periodo periodo;

	@Column(name = "valor", nullable = false, precision = 15, scale = 4)
	private BigDecimal valor;

	@Column(name = "congelado", nullable = false)
	private boolean congelado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meta_id")
	private Meta meta;

	@Enumerated(EnumType.STRING)
	@Column(name = "semaforo", length = 40)
	private Semaforo semaforo;

	protected ResultadoIndicador() {
	}

	public ResultadoIndicador(
			UUID unidadeId,
			String codigoIndicador,
			LocalDate data,
			Periodo periodo,
			BigDecimal valor,
			boolean congelado) {
		super(unidadeId);
		this.codigoIndicador = codigoIndicador;
		this.data = data;
		this.periodo = periodo;
		this.valor = valor;
		this.congelado = congelado;
	}

	public String getCodigoIndicador() {
		return codigoIndicador;
	}

	public LocalDate getData() {
		return data;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public boolean isCongelado() {
		return congelado;
	}

	public Meta getMeta() {
		return meta;
	}

	public Semaforo getSemaforo() {
		return semaforo;
	}

}
