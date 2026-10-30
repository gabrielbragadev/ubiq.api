package br.com.basetech.ubiq.api.coleta.domain;

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

import java.time.Instant;
import java.util.UUID;

/**
 * Amostra com identificação única, ligada ao paciente e à solicitação (Coleta · Regras 4 e 6).
 */
@Entity
@Table(name = "amostra", uniqueConstraints = {
		@UniqueConstraint(name = "uk_amostra_identificacao", columnNames = {"identificacao"})
})
public class Amostra extends EntidadeOperacional {

	@Column(name = "identificacao", nullable = false)
	private String identificacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "solicitacao_id", nullable = false)
	private SolicitacaoExame solicitacao;

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusAmostra status;

	@Column(name = "coletada_em", nullable = false)
	private Instant coletadaEm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lote_envio_id")
	private LoteEnvio loteEnvio;

	protected Amostra() {
	}

	public Amostra(
			UUID unidadeId,
			String identificacao,
			SolicitacaoExame solicitacao,
			UUID pacienteId,
			StatusAmostra status,
			Instant coletadaEm) {
		super(unidadeId);
		this.identificacao = identificacao;
		this.solicitacao = solicitacao;
		this.pacienteId = pacienteId;
		this.status = status;
		this.coletadaEm = coletadaEm;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public SolicitacaoExame getSolicitacao() {
		return solicitacao;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public StatusAmostra getStatus() {
		return status;
	}

	public Instant getColetadaEm() {
		return coletadaEm;
	}

	public LoteEnvio getLoteEnvio() {
		return loteEnvio;
	}

}
