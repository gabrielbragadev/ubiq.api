package br.com.basetech.ubiq.api.territorio.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Equipe de uma unidade (Território · Regra 1).
 */
@Entity
@Table(name = "equipe")
public class Equipe extends EntidadeOperacional {

	@Column(name = "nome", nullable = false)
	private String nome;

	protected Equipe() {
	}

	public Equipe(UUID unidadeId, String nome) {
		super(unidadeId);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
