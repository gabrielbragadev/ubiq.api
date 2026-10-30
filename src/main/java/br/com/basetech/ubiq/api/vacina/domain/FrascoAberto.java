package br.com.basetech.ubiq.api.vacina.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * Frasco multidose aberto (Vacinas · Regra 2).
 */
@Entity
@Table(name = "frasco_aberto")
public class FrascoAberto extends EntidadeOperacional {

	@Column(name = "lote_id", nullable = false)
	private UUID loteId;

	@Column(name = "aberto_em", nullable = false)
	private Instant abertoEm;

	@Column(name = "vence_em", nullable = false)
	private Instant venceEm;

	@Column(name = "doses_restantes", nullable = false, precision = 15, scale = 3)
	private BigDecimal dosesRestantes;

	protected FrascoAberto() {
	}

	public FrascoAberto(
			UUID unidadeId,
			UUID loteId,
			Instant abertoEm,
			Instant venceEm,
			BigDecimal dosesRestantes) {
		super(unidadeId);
		this.loteId = loteId;
		this.abertoEm = abertoEm;
		this.venceEm = venceEm;
		this.dosesRestantes = dosesRestantes;
	}

	public UUID getLoteId() {
		return loteId;
	}

	public Instant getAbertoEm() {
		return abertoEm;
	}

	public Instant getVenceEm() {
		return venceEm;
	}

	public BigDecimal getDosesRestantes() {
		return dosesRestantes;
	}

}
