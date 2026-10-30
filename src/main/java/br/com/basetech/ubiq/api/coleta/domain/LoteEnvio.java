package br.com.basetech.ubiq.api.coleta.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Lote de amostras enviado ao laboratório (Coleta · Regra 5).
 */
@Entity
@Table(name = "lote_envio")
public class LoteEnvio extends EntidadeOperacional {

	@Column(name = "saida_em", nullable = false)
	private Instant saidaEm;

	@Column(name = "condicao_transporte", nullable = false)
	private String condicaoTransporte;

	@Column(name = "responsavel_id", nullable = false)
	private UUID responsavelId;

	@Column(name = "recebido_em")
	private Instant recebidoEm;

	@Column(name = "recebedor")
	private String recebedor;

	protected LoteEnvio() {
	}

	public LoteEnvio(UUID unidadeId, Instant saidaEm, String condicaoTransporte, UUID responsavelId) {
		super(unidadeId);
		this.saidaEm = saidaEm;
		this.condicaoTransporte = condicaoTransporte;
		this.responsavelId = responsavelId;
	}

	public Instant getSaidaEm() {
		return saidaEm;
	}

	public String getCondicaoTransporte() {
		return condicaoTransporte;
	}

	public UUID getResponsavelId() {
		return responsavelId;
	}

	public Instant getRecebidoEm() {
		return recebidoEm;
	}

	public String getRecebedor() {
		return recebedor;
	}

}
