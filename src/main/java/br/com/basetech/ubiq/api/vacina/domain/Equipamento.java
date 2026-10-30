package br.com.basetech.ubiq.api.vacina.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Equipamento da rede de frio em um local de estoque (Vacinas · Regras 3 e 4).
 */
@Entity
@Table(name = "equipamento")
public class Equipamento extends EntidadeOperacional {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "local_id", nullable = false)
	private UUID localId;

	protected Equipamento() {
	}

	public Equipamento(UUID unidadeId, String nome, UUID localId) {
		super(unidadeId);
		this.nome = nome;
		this.localId = localId;
	}

	public String getNome() {
		return nome;
	}

	public UUID getLocalId() {
		return localId;
	}

}
