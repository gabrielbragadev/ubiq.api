package br.com.basetech.ubiq.api.territorio.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Família de um domicílio (Território · Regra 1).
 */
@Entity
@Table(name = "familia")
public class Familia extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "domicilio_id", nullable = false)
	private Domicilio domicilio;

	protected Familia() {
	}

	public Familia(UUID unidadeId, Domicilio domicilio) {
		super(unidadeId);
		this.domicilio = domicilio;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

}
