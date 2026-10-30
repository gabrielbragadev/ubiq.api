package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Saldo de um item por local e lote, que nunca fica negativo (Estoque · Regra 5; Regras gerais · Regra 6).
 */
@Entity
@Table(name = "saldo", uniqueConstraints = {
		@UniqueConstraint(name = "uk_saldo_item_lote_local", columnNames = {"item_id", "lote_id", "local_id"})
})
@Check(name = "ck_saldo_quantidade", constraints = "quantidade >= 0")
public class Saldo extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lote_id")
	private Lote lote;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "local_id", nullable = false)
	private Local local;

	@Column(name = "quantidade", nullable = false, precision = 15, scale = 3)
	private BigDecimal quantidade;

	@Version
	@Column(name = "version", nullable = false)
	private Long versao;

	protected Saldo() {
	}

	public Saldo(UUID unidadeId, Item item, Local local, BigDecimal quantidade) {
		super(unidadeId);
		this.item = item;
		this.local = local;
		this.quantidade = quantidade;
	}

	public Item getItem() {
		return item;
	}

	public Lote getLote() {
		return lote;
	}

	public Local getLocal() {
		return local;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public Long getVersao() {
		return versao;
	}

}
