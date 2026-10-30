package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Item de uma requisição, com quantidade pedida e atendida (Estoque · Regra 11).
 */
@Entity
@Table(name = "item_requisicao")
public class ItemRequisicao extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requisicao_id", nullable = false)
	private Requisicao requisicao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	@Column(name = "quantidade_pedida", nullable = false, precision = 15, scale = 3)
	private BigDecimal quantidadePedida;

	@Column(name = "quantidade_atendida", precision = 15, scale = 3)
	private BigDecimal quantidadeAtendida;

	protected ItemRequisicao() {
	}

	public ItemRequisicao(UUID unidadeId, Requisicao requisicao, Item item, BigDecimal quantidadePedida) {
		super(unidadeId);
		this.requisicao = requisicao;
		this.item = item;
		this.quantidadePedida = quantidadePedida;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public Item getItem() {
		return item;
	}

	public BigDecimal getQuantidadePedida() {
		return quantidadePedida;
	}

	public BigDecimal getQuantidadeAtendida() {
		return quantidadeAtendida;
	}

}
