package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Tratamento odontológico aberto na primeira consulta programática (Agenda · Regra 19).
 */
@Entity
@Table(name = "tratamento")
public class Tratamento extends EntidadeOperacional {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Column(name = "profissional_id", nullable = false)
	private UUID profissionalId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusTratamento status;

	protected Tratamento() {
	}

	public Tratamento(UUID unidadeId, UUID pacienteId, UUID profissionalId, StatusTratamento status) {
		super(unidadeId);
		this.pacienteId = pacienteId;
		this.profissionalId = profissionalId;
		this.status = status;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public StatusTratamento getStatus() {
		return status;
	}

}
