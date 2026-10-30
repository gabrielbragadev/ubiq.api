package br.com.basetech.ubiq.api.vacina.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Leitura de temperatura de um equipamento (Vacinas · Regra 3).
 */
@Entity
@Table(name = "leitura_temperatura")
public class LeituraTemperatura extends EntidadeBase {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipamento_id", nullable = false)
	private Equipamento equipamento;

	@Column(name = "lida_em", nullable = false)
	private Instant lidaEm;

	@Column(name = "minima", nullable = false, precision = 5, scale = 2)
	private BigDecimal minima;

	@Column(name = "maxima", nullable = false, precision = 5, scale = 2)
	private BigDecimal maxima;

	@Column(name = "atual", nullable = false, precision = 5, scale = 2)
	private BigDecimal atual;

	protected LeituraTemperatura() {
	}

	public LeituraTemperatura(
			Equipamento equipamento,
			Instant lidaEm,
			BigDecimal minima,
			BigDecimal maxima,
			BigDecimal atual) {
		this.equipamento = equipamento;
		this.lidaEm = lidaEm;
		this.minima = minima;
		this.maxima = maxima;
		this.atual = atual;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public Instant getLidaEm() {
		return lidaEm;
	}

	public BigDecimal getMinima() {
		return minima;
	}

	public BigDecimal getMaxima() {
		return maxima;
	}

	public BigDecimal getAtual() {
		return atual;
	}

}
