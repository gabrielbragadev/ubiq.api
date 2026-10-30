package br.com.basetech.ubiq.api.territorio.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;

import java.time.Instant;
import java.util.UUID;

/**
 * Tarefa da fila do ACS, encerrada só com desfecho (Território · Regra 4).
 */
@Entity
@Table(name = "tarefa")
@Check(name = "ck_tarefa_desfecho", constraints = "status <> 'ENCERRADA' or desfecho is not null")
public class Tarefa extends EntidadeOperacional {

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoTarefa tipo;

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "microarea_id", nullable = false)
	private Microarea microarea;

	@Column(name = "prazo", nullable = false)
	private Instant prazo;

	@Column(name = "desfecho")
	private String desfecho;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusTarefa status;

	protected Tarefa() {
	}

	public Tarefa(
			UUID unidadeId,
			TipoTarefa tipo,
			UUID pacienteId,
			Microarea microarea,
			Instant prazo,
			StatusTarefa status) {
		super(unidadeId);
		this.tipo = tipo;
		this.pacienteId = pacienteId;
		this.microarea = microarea;
		this.prazo = prazo;
		this.status = status;
	}

	public TipoTarefa getTipo() {
		return tipo;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public Microarea getMicroarea() {
		return microarea;
	}

	public Instant getPrazo() {
		return prazo;
	}

	public String getDesfecho() {
		return desfecho;
	}

	public StatusTarefa getStatus() {
		return status;
	}

}
