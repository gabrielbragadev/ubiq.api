package br.com.basetech.ubiq.api.escala.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Versão da escala mensal, com todas as versões guardadas (Escalas · Regras 5 e 9).
 */
@Entity
@Table(name = "escala", uniqueConstraints = {
		@UniqueConstraint(name = "uk_escala_unidade_mes_versao", columnNames = {"unidade_id", "mes", "versao"})
})
public class Escala extends EntidadeOperacional {

	@Column(name = "mes", nullable = false)
	private LocalDate mes;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusEscala status;

	@Column(name = "versao", nullable = false)
	private int versao;

	protected Escala() {
	}

	public Escala(UUID unidadeId, LocalDate mes, StatusEscala status, int versao) {
		super(unidadeId);
		this.mes = mes;
		this.status = status;
		this.versao = versao;
	}

	public LocalDate getMes() {
		return mes;
	}

	public StatusEscala getStatus() {
		return status;
	}

	public int getVersao() {
		return versao;
	}

}
