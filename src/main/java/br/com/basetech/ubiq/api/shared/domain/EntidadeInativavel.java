package br.com.basetech.ubiq.api.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

import java.time.Instant;
import java.util.UUID;

/**
 * Base dos registros que nunca são excluídos fisicamente (Regras gerais · Regra 2).
 */
@MappedSuperclass
public abstract class EntidadeInativavel extends EntidadeBase {

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", nullable = false, length = 40)
	private Situacao situacao = Situacao.ATIVO;

	@Column(name = "motivo_inativacao")
	private String motivoInativacao;

	@Column(name = "inativado_por")
	private UUID inativadoPor;

	@Column(name = "inativado_em")
	private Instant inativadoEm;

	public Situacao getSituacao() {
		return situacao;
	}

	public String getMotivoInativacao() {
		return motivoInativacao;
	}

	public UUID getInativadoPor() {
		return inativadoPor;
	}

	public Instant getInativadoEm() {
		return inativadoEm;
	}

}
