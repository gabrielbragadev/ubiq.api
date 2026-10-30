package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Transferência entre unidades; unidadeId é a origem (Multiunidade · Regra 4).
 */
@Entity
@Table(name = "transferencia")
public class Transferencia extends EntidadeOperacional {

	@Column(name = "unidade_destino_id", nullable = false)
	private UUID unidadeDestinoId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lote_id")
	private Lote lote;

	@Column(name = "quantidade", nullable = false, precision = 15, scale = 3)
	private BigDecimal quantidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusTransferencia status;

	@Column(name = "divergencia")
	private String divergencia;

	@Column(name = "aprovado_por")
	private UUID aprovadoPor;

	protected Transferencia() {
	}

	public Transferencia(
			UUID unidadeId,
			UUID unidadeDestinoId,
			Item item,
			BigDecimal quantidade,
			StatusTransferencia status) {
		super(unidadeId);
		this.unidadeDestinoId = unidadeDestinoId;
		this.item = item;
		this.quantidade = quantidade;
		this.status = status;
	}

	public UUID getUnidadeDestinoId() {
		return unidadeDestinoId;
	}

	public Item getItem() {
		return item;
	}

	public Lote getLote() {
		return lote;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public StatusTransferencia getStatus() {
		return status;
	}

	public String getDivergencia() {
		return divergencia;
	}

	public UUID getAprovadoPor() {
		return aprovadoPor;
	}

}
