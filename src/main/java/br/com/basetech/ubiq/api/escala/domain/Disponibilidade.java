package br.com.basetech.ubiq.api.escala.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Disponibilidade recorrente do profissional (Escalas · Regra 1).
 */
@Entity
@Table(name = "disponibilidade")
public class Disponibilidade extends EntidadeOperacional {

	@Column(name = "profissional_id", nullable = false)
	private UUID profissionalId;

	@Enumerated(EnumType.STRING)
	@Column(name = "dia_semana", nullable = false, length = 40)
	private DayOfWeek diaSemana;

	@Column(name = "hora_inicio", nullable = false)
	private LocalTime horaInicio;

	@Column(name = "hora_fim", nullable = false)
	private LocalTime horaFim;

	protected Disponibilidade() {
	}

	public Disponibilidade(
			UUID unidadeId,
			UUID profissionalId,
			DayOfWeek diaSemana,
			LocalTime horaInicio,
			LocalTime horaFim) {
		super(unidadeId);
		this.profissionalId = profissionalId;
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

}
