package br.com.basetech.ubiq.api.coleta.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Solicitação de exame emitida no módulo Documentos ou externa (Coleta · Regras 2 e 3).
 */
@Entity
@Table(name = "solicitacao_exame")
public class SolicitacaoExame extends EntidadeOperacional {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Enumerated(EnumType.STRING)
	@Column(name = "origem", nullable = false, length = 40)
	private OrigemSolicitacao origem;

	@Column(name = "documento_id")
	private UUID documentoId;

	@Column(name = "exames", nullable = false, columnDefinition = "text")
	private String exames;

	@Column(name = "sensivel", nullable = false)
	private boolean sensivel;

	@Column(name = "agendamento_id")
	private UUID agendamentoId;

	protected SolicitacaoExame() {
	}

	public SolicitacaoExame(
			UUID unidadeId,
			UUID pacienteId,
			OrigemSolicitacao origem,
			String exames,
			boolean sensivel) {
		super(unidadeId);
		this.pacienteId = pacienteId;
		this.origem = origem;
		this.exames = exames;
		this.sensivel = sensivel;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public OrigemSolicitacao getOrigem() {
		return origem;
	}

	public UUID getDocumentoId() {
		return documentoId;
	}

	public String getExames() {
		return exames;
	}

	public boolean isSensivel() {
		return sensivel;
	}

	public UUID getAgendamentoId() {
		return agendamentoId;
	}

}
