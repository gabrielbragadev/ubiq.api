package br.com.basetech.ubiq.api.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

/**
 * Base dos registros operacionais, que sempre pertencem a uma unidade (Regras gerais · Regra 1).
 */
@MappedSuperclass
public abstract class EntidadeOperacional extends EntidadeInativavel {

	@Column(name = "unidade_id", nullable = false)
	private UUID unidadeId;

	protected EntidadeOperacional() {
	}

	protected EntidadeOperacional(UUID unidadeId) {
		this.unidadeId = unidadeId;
	}

	public UUID getUnidadeId() {
		return unidadeId;
	}

}
