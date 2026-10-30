package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

/**
 * Inscrição individual em um grupo, com presença por participante (Agenda · Regra 18).
 */
@Entity
@Table(name = "inscricao", uniqueConstraints = {
		@UniqueConstraint(name = "uk_inscricao_grupo_paciente", columnNames = {"grupo_id", "paciente_id"})
})
public class Inscricao extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grupo_id", nullable = false)
	private Grupo grupo;

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Column(name = "presente")
	private Boolean presente;

	protected Inscricao() {
	}

	public Inscricao(UUID unidadeId, Grupo grupo, UUID pacienteId) {
		super(unidadeId);
		this.grupo = grupo;
		this.pacienteId = pacienteId;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public Boolean getPresente() {
		return presente;
	}

}
