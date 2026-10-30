package br.com.basetech.ubiq.api.listaespera.domain;

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
 * Oferta de uma vaga liberada, com prazo de aceite (Lista de espera · Regra 3).
 */
@Entity
@Table(name = "oferta_vaga")
public class OfertaVaga extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entrada_id", nullable = false)
	private EntradaListaEspera entrada;

	@Column(name = "vaga_id", nullable = false)
	private UUID vagaId;

	@Column(name = "prazo", nullable = false)
	private Instant prazo;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusOferta status;

	protected OfertaVaga() {
	}

	public OfertaVaga(
			UUID unidadeId,
			EntradaListaEspera entrada,
			UUID vagaId,
			Instant prazo,
			StatusOferta status) {
		super(unidadeId);
		this.entrada = entrada;
		this.vagaId = vagaId;
		this.prazo = prazo;
		this.status = status;
	}

	public EntradaListaEspera getEntrada() {
		return entrada;
	}

	public UUID getVagaId() {
		return vagaId;
	}

	public Instant getPrazo() {
		return prazo;
	}

	public StatusOferta getStatus() {
		return status;
	}

}
