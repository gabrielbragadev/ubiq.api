package br.com.basetech.ubiq.api.documento.domain;

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
 * Medicamento de uma receita (Documentos · Regras 5 e 12).
 */
@Entity
@Table(name = "item_receita")
public class ItemReceita extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_id", nullable = false)
	private Documento documento;

	@Column(name = "item_id")
	private UUID itemId;

	@Column(name = "medicamento", nullable = false)
	private String medicamento;

	@Column(name = "concentracao", nullable = false)
	private String concentracao;

	@Column(name = "forma", nullable = false)
	private String forma;

	@Column(name = "posologia", nullable = false)
	private String posologia;

	@Column(name = "quantidade", nullable = false, precision = 15, scale = 3)
	private BigDecimal quantidade;

	@Column(name = "via", nullable = false)
	private String via;

	@Column(name = "fora_da_lista", nullable = false)
	private boolean foraDaLista;

	protected ItemReceita() {
	}

	public ItemReceita(
			UUID unidadeId,
			Documento documento,
			String medicamento,
			String concentracao,
			String forma,
			String posologia,
			BigDecimal quantidade,
			String via,
			boolean foraDaLista) {
		super(unidadeId);
		this.documento = documento;
		this.medicamento = medicamento;
		this.concentracao = concentracao;
		this.forma = forma;
		this.posologia = posologia;
		this.quantidade = quantidade;
		this.via = via;
		this.foraDaLista = foraDaLista;
	}

	public Documento getDocumento() {
		return documento;
	}

	public UUID getItemId() {
		return itemId;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public String getConcentracao() {
		return concentracao;
	}

	public String getForma() {
		return forma;
	}

	public String getPosologia() {
		return posologia;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public String getVia() {
		return via;
	}

	public boolean isForaDaLista() {
		return foraDaLista;
	}

}
