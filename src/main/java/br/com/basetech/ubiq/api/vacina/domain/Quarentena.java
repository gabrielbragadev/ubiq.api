package br.com.basetech.ubiq.api.vacina.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Quarentena de um lote após excursão de temperatura (Vacinas · Regra 4).
 */
@Entity
@Table(name = "quarentena")
public class Quarentena extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipamento_id", nullable = false)
	private Equipamento equipamento;

	@Column(name = "lote_id", nullable = false)
	private UUID loteId;

	@Column(name = "inicio", nullable = false)
	private Instant inicio;

	@Enumerated(EnumType.STRING)
	@Column(name = "parecer", length = 40)
	private ParecerQuarentena parecer;

	@Column(name = "parecer_em")
	private Instant parecerEm;

	protected Quarentena() {
	}

	public Quarentena(UUID unidadeId, Equipamento equipamento, UUID loteId, Instant inicio) {
		super(unidadeId);
		this.equipamento = equipamento;
		this.loteId = loteId;
		this.inicio = inicio;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public UUID getLoteId() {
		return loteId;
	}

	public Instant getInicio() {
		return inicio;
	}

	public ParecerQuarentena getParecer() {
		return parecer;
	}

	public Instant getParecerEm() {
		return parecerEm;
	}

}
