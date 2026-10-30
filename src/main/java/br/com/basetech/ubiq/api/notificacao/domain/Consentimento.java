package br.com.basetech.ubiq.api.notificacao.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Opt-in do paciente para um canal opcional (Cadastros · Regra 7; LGPD · Regra 1).
 */
@Entity
@Table(name = "consentimento")
public class Consentimento extends EntidadeInativavel {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Enumerated(EnumType.STRING)
	@Column(name = "canal", nullable = false, length = 40)
	private CanalMensagem canal;

	@Column(name = "data", nullable = false)
	private Instant data;

	@Column(name = "origem", nullable = false)
	private String origem;

	protected Consentimento() {
	}

	public Consentimento(UUID pacienteId, CanalMensagem canal, Instant data, String origem) {
		this.pacienteId = pacienteId;
		this.canal = canal;
		this.data = data;
		this.origem = origem;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public CanalMensagem getCanal() {
		return canal;
	}

	public Instant getData() {
		return data;
	}

	public String getOrigem() {
		return origem;
	}

}
