package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.time.Instant;
import java.util.UUID;

/**
 * Vaga de um turno, com cota e versão para reserva concorrente (Agenda · Regras 2, 8 e 10).
 */
@Entity
@Table(name = "vaga")
public class Vaga extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "turno_id", nullable = false)
	private Turno turno;

	@Enumerated(EnumType.STRING)
	@Column(name = "cota", nullable = false, length = 40)
	private Cota cota;

	@Column(name = "inicio", nullable = false)
	private Instant inicio;

	@Column(name = "fim", nullable = false)
	private Instant fim;

	@Column(name = "pre_reservada_ate")
	private Instant preReservadaAte;

	@Version
	@Column(name = "version", nullable = false)
	private Long versao;

	protected Vaga() {
	}

	public Vaga(UUID unidadeId, Turno turno, Cota cota, Instant inicio, Instant fim) {
		super(unidadeId);
		this.turno = turno;
		this.cota = cota;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Turno getTurno() {
		return turno;
	}

	public Cota getCota() {
		return cota;
	}

	public Instant getInicio() {
		return inicio;
	}

	public Instant getFim() {
		return fim;
	}

	public Instant getPreReservadaAte() {
		return preReservadaAte;
	}

	public Long getVersao() {
		return versao;
	}

}
