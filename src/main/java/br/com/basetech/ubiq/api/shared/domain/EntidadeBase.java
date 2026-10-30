package br.com.basetech.ubiq.api.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.Instant;
import java.util.UUID;

/**
 * Base de todas as entidades: id e auditoria de criação e alteração.
 * Os campos de usuário ficam nulos até o login existir (T-026).
 */
@MappedSuperclass
public abstract class EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;

	@Column(name = "criado_em", nullable = false, updatable = false)
	private Instant criadoEm;

	@Column(name = "atualizado_em", nullable = false)
	private Instant atualizadoEm;

	@Column(name = "criado_por", updatable = false)
	private UUID criadoPor;

	@Column(name = "atualizado_por")
	private UUID atualizadoPor;

	@PrePersist
	protected void aoCriar() {
		Instant agora = Instant.now();
		criadoEm = agora;
		atualizadoEm = agora;
	}

	@PreUpdate
	protected void aoAtualizar() {
		atualizadoEm = Instant.now();
	}

	public UUID getId() {
		return id;
	}

	public Instant getCriadoEm() {
		return criadoEm;
	}

	public Instant getAtualizadoEm() {
		return atualizadoEm;
	}

	public UUID getCriadoPor() {
		return criadoPor;
	}

	public UUID getAtualizadoPor() {
		return atualizadoPor;
	}

	@Override
	public boolean equals(Object outro) {
		if (this == outro) {
			return true;
		}
		return outro instanceof EntidadeBase entidade && getId() != null && getId().equals(entidade.getId());
	}

	@Override
	public int hashCode() {
		return EntidadeBase.class.hashCode();
	}

}
