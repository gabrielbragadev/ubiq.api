package br.com.basetech.ubiq.api.documento.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Encaminhamento com status acompanhável (Documentos · Regras 5 e 13).
 */
@Entity
@Table(name = "encaminhamento")
public class Encaminhamento extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_id", nullable = false)
	private Documento documento;

	@Column(name = "especialidade", nullable = false)
	private String especialidade;

	@Column(name = "justificativa_clinica", nullable = false, columnDefinition = "text")
	private String justificativaClinica;

	@Column(name = "prioridade", nullable = false)
	private String prioridade;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusEncaminhamento status;

	protected Encaminhamento() {
	}

	public Encaminhamento(
			UUID unidadeId,
			Documento documento,
			String especialidade,
			String justificativaClinica,
			String prioridade,
			StatusEncaminhamento status) {
		super(unidadeId);
		this.documento = documento;
		this.especialidade = especialidade;
		this.justificativaClinica = justificativaClinica;
		this.prioridade = prioridade;
		this.status = status;
	}

	public Documento getDocumento() {
		return documento;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getJustificativaClinica() {
		return justificativaClinica;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public StatusEncaminhamento getStatus() {
		return status;
	}

}
