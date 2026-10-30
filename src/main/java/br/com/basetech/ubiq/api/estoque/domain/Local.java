package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Local de estoque de uma unidade (Estoque · Regra 2).
 */
@Entity
@Table(name = "local")
public class Local extends EntidadeOperacional {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoLocal tipo;

	protected Local() {
	}

	public Local(UUID unidadeId, String nome, TipoLocal tipo) {
		super(unidadeId);
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public TipoLocal getTipo() {
		return tipo;
	}

}
