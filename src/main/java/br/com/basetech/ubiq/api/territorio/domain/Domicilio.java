package br.com.basetech.ubiq.api.territorio.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Domicílio de uma microárea (Território · Regra 1).
 */
@Entity
@Table(name = "domicilio")
public class Domicilio extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "microarea_id", nullable = false)
	private Microarea microarea;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	protected Domicilio() {
	}

	public Domicilio(UUID unidadeId, Microarea microarea, String endereco) {
		super(unidadeId);
		this.microarea = microarea;
		this.endereco = endereco;
	}

	public Microarea getMicroarea() {
		return microarea;
	}

	public String getEndereco() {
		return endereco;
	}

}
