package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Requisição interna de um setor (Estoque · Regra 11).
 */
@Entity
@Table(name = "requisicao")
public class Requisicao extends EntidadeOperacional {

	@Column(name = "setor_solicitante_id", nullable = false)
	private UUID setorSolicitanteId;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusRequisicao status;

	@Column(name = "motivo_negativa")
	private String motivoNegativa;

	@Column(name = "justificativa")
	private String justificativa;

	@OneToMany(mappedBy = "requisicao")
	private List<ItemRequisicao> itens = new ArrayList<>();

	protected Requisicao() {
	}

	public Requisicao(UUID unidadeId, UUID setorSolicitanteId, StatusRequisicao status) {
		super(unidadeId);
		this.setorSolicitanteId = setorSolicitanteId;
		this.status = status;
	}

	public UUID getSetorSolicitanteId() {
		return setorSolicitanteId;
	}

	public StatusRequisicao getStatus() {
		return status;
	}

	public String getMotivoNegativa() {
		return motivoNegativa;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public List<ItemRequisicao> getItens() {
		return Collections.unmodifiableList(itens);
	}

}
