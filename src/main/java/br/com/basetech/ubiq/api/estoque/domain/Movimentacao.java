package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * Movimentação de estoque; o usuário e a data-hora ficam em criadoPor e criadoEm (Estoque · Regras 5 e 14).
 */
@Entity
@Table(name = "movimentacao")
public class Movimentacao extends EntidadeBase {

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoMovimentacao tipo;

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

	@Column(name = "motivo", nullable = false)
	private String motivo;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_perda", length = 40)
	private TipoPerda tipoPerda;

	protected Movimentacao() {
	}

	public Movimentacao(TipoMovimentacao tipo, Item item, Local local, BigDecimal quantidade, String motivo) {
		this.tipo = tipo;
		this.item = item;
		this.local = local;
		this.quantidade = quantidade;
		this.motivo = motivo;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
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

	public String getMotivo() {
		return motivo;
	}

	public TipoPerda getTipoPerda() {
		return tipoPerda;
	}

}
