package br.com.basetech.ubiq.api.farmacia.domain;

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
 * Dispensação vinculada a paciente e receita (Farmácia · Regras 1, 3, 4 e 5).
 */
@Entity
@Table(name = "dispensacao")
public class Dispensacao extends EntidadeOperacional {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receita_id", nullable = false)
	private Receita receita;

	@Column(name = "item_id", nullable = false)
	private UUID itemId;

	@Column(name = "quantidade", nullable = false, precision = 15, scale = 3)
	private BigDecimal quantidade;

	@Column(name = "saldo_adispensar", nullable = false, precision = 15, scale = 3)
	private BigDecimal saldoADispensar;

	@Column(name = "justificativa")
	private String justificativa;

	@Column(name = "dados_comprador")
	private String dadosComprador;

	protected Dispensacao() {
	}

	public Dispensacao(
			UUID unidadeId,
			UUID pacienteId,
			Receita receita,
			UUID itemId,
			BigDecimal quantidade,
			BigDecimal saldoADispensar) {
		super(unidadeId);
		this.pacienteId = pacienteId;
		this.receita = receita;
		this.itemId = itemId;
		this.quantidade = quantidade;
		this.saldoADispensar = saldoADispensar;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public Receita getReceita() {
		return receita;
	}

	public UUID getItemId() {
		return itemId;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public BigDecimal getSaldoADispensar() {
		return saldoADispensar;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public String getDadosComprador() {
		return dadosComprador;
	}

}
