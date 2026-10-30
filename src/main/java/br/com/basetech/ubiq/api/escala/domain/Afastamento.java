package br.com.basetech.ubiq.api.escala.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Exceção à disponibilidade do profissional (Escalas · Regra 1).
 */
@Entity
@Table(name = "afastamento")
public class Afastamento extends EntidadeOperacional {

	@Column(name = "profissional_id", nullable = false)
	private UUID profissionalId;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoAfastamento tipo;

	@Column(name = "inicio", nullable = false)
	private LocalDate inicio;

	@Column(name = "fim", nullable = false)
	private LocalDate fim;

	protected Afastamento() {
	}

	public Afastamento(
			UUID unidadeId,
			UUID profissionalId,
			TipoAfastamento tipo,
			LocalDate inicio,
			LocalDate fim) {
		super(unidadeId);
		this.profissionalId = profissionalId;
		this.tipo = tipo;
		this.inicio = inicio;
		this.fim = fim;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public TipoAfastamento getTipo() {
		return tipo;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

}
