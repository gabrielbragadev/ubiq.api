package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Turno de atendimento de um profissional.
 */
@Entity
@Table(name = "turno")
public class Turno extends EntidadeOperacional {

	@Column(name = "profissional_id", nullable = false)
	private UUID profissionalId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_atendimento_id", nullable = false)
	private TipoAtendimento tipoAtendimento;

	@Column(name = "inicio", nullable = false)
	private Instant inicio;

	@Column(name = "fim", nullable = false)
	private Instant fim;

	@Column(name = "turno_escala_id")
	private UUID turnoEscalaId;

	protected Turno() {
	}

	public Turno(
			UUID unidadeId,
			UUID profissionalId,
			TipoAtendimento tipoAtendimento,
			Instant inicio,
			Instant fim) {
		super(unidadeId);
		this.profissionalId = profissionalId;
		this.tipoAtendimento = tipoAtendimento;
		this.inicio = inicio;
		this.fim = fim;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public Instant getInicio() {
		return inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public UUID getTurnoEscalaId() {
		return turnoEscalaId;
	}

}
