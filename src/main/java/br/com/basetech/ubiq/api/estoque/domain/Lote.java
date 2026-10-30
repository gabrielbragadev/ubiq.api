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
import jakarta.persistence.UniqueConstraint;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Lote recebido por uma unidade; em imunobiológicos, o fabricante é o laboratório (Estoque · Regras 3 e 16; Vacinas · Regra 1).
 */
@Entity
@Table(name = "lote", uniqueConstraints = {
		@UniqueConstraint(name = "uk_lote_unidade_item_numero", columnNames = {"unidade_id", "item_id", "numero"})
})
public class Lote extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "validade", nullable = false)
	private LocalDate validade;

	@Column(name = "fabricante", nullable = false)
	private String fabricante;

	@Column(name = "custo_unitario", nullable = false, precision = 15, scale = 4)
	private BigDecimal custoUnitario;

	@Enumerated(EnumType.STRING)
	@Column(name = "origem", nullable = false, length = 40)
	private OrigemEntrada origem;

	@Column(name = "documento_entrada", nullable = false)
	private String documentoEntrada;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusLote status;

	@Enumerated(EnumType.STRING)
	@Column(name = "apresentacao", length = 40)
	private Apresentacao apresentacao;

	@Column(name = "doses_por_frasco", precision = 15, scale = 3)
	private BigDecimal dosesPorFrasco;

	protected Lote() {
	}

	public Lote(
			UUID unidadeId,
			Item item,
			String numero,
			LocalDate validade,
			String fabricante,
			BigDecimal custoUnitario,
			OrigemEntrada origem,
			String documentoEntrada,
			StatusLote status) {
		super(unidadeId);
		this.item = item;
		this.numero = numero;
		this.validade = validade;
		this.fabricante = fabricante;
		this.custoUnitario = custoUnitario;
		this.origem = origem;
		this.documentoEntrada = documentoEntrada;
		this.status = status;
	}

	public Item getItem() {
		return item;
	}

	public String getNumero() {
		return numero;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public String getFabricante() {
		return fabricante;
	}

	public BigDecimal getCustoUnitario() {
		return custoUnitario;
	}

	public OrigemEntrada getOrigem() {
		return origem;
	}

	public String getDocumentoEntrada() {
		return documentoEntrada;
	}

	public StatusLote getStatus() {
		return status;
	}

	public Apresentacao getApresentacao() {
		return apresentacao;
	}

	public BigDecimal getDosesPorFrasco() {
		return dosesPorFrasco;
	}

}
