package br.com.basetech.ubiq.api.notificacao.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Mensagem a um paciente, com status de entrega (Notificações · Regra 8).
 */
@Entity
@Table(name = "mensagem")
public class Mensagem extends EntidadeOperacional {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelo_id", nullable = false)
	private ModeloMensagem modelo;

	@Enumerated(EnumType.STRING)
	@Column(name = "canal", nullable = false, length = 40)
	private CanalMensagem canal;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusMensagem status;

	@Column(name = "enviada_em")
	private Instant enviadaEm;

	@Column(name = "motivo_falha")
	private String motivoFalha;

	protected Mensagem() {
	}

	public Mensagem(
			UUID unidadeId,
			UUID pacienteId,
			ModeloMensagem modelo,
			CanalMensagem canal,
			StatusMensagem status) {
		super(unidadeId);
		this.pacienteId = pacienteId;
		this.modelo = modelo;
		this.canal = canal;
		this.status = status;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public ModeloMensagem getModelo() {
		return modelo;
	}

	public CanalMensagem getCanal() {
		return canal;
	}

	public StatusMensagem getStatus() {
		return status;
	}

	public Instant getEnviadaEm() {
		return enviadaEm;
	}

	public String getMotivoFalha() {
		return motivoFalha;
	}

}
