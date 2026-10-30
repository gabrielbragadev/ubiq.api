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
 * Parte do território da equipe, com ACS responsável e substituto (Território · Regra 1).
 */
@Entity
@Table(name = "microarea")
public class Microarea extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipe_id", nullable = false)
	private Equipe equipe;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "acs_responsavel_id", nullable = false)
	private UUID acsResponsavelId;

	@Column(name = "acs_substituto_id", nullable = false)
	private UUID acsSubstitutoId;

	protected Microarea() {
	}

	public Microarea(UUID unidadeId, Equipe equipe, String nome, UUID acsResponsavelId, UUID acsSubstitutoId) {
		super(unidadeId);
		this.equipe = equipe;
		this.nome = nome;
		this.acsResponsavelId = acsResponsavelId;
		this.acsSubstitutoId = acsSubstitutoId;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public String getNome() {
		return nome;
	}

	public UUID getAcsResponsavelId() {
		return acsResponsavelId;
	}

	public UUID getAcsSubstitutoId() {
		return acsSubstitutoId;
	}

}
