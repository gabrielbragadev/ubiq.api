package br.com.basetech.ubiq.api.escala.domain;

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
 * Turno de um profissional na escala (Escalas · Regras 4, 8 e 10).
 */
@Entity
@Table(name = "turno_escala")
public class TurnoEscala extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "escala_id", nullable = false)
	private Escala escala;

	@Column(name = "profissional_id", nullable = false)
	private UUID profissionalId;

	@Column(name = "inicio", nullable = false)
	private Instant inicio;

	@Column(name = "fim", nullable = false)
	private Instant fim;

	@Column(name = "setor_id")
	private UUID setorId;

	@Column(name = "tipo_atendimento_id")
	private UUID tipoAtendimentoId;

	@Column(name = "justificativa")
	private String justificativa;

	@Column(name = "motivo_alteracao")
	private String motivoAlteracao;

	protected TurnoEscala() {
	}

	public TurnoEscala(UUID unidadeId, Escala escala, UUID profissionalId, Instant inicio, Instant fim) {
		super(unidadeId);
		this.escala = escala;
		this.profissionalId = profissionalId;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Escala getEscala() {
		return escala;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public Instant getInicio() {
		return inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public UUID getSetorId() {
		return setorId;
	}

	public UUID getTipoAtendimentoId() {
		return tipoAtendimentoId;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public String getMotivoAlteracao() {
		return motivoAlteracao;
	}

}
