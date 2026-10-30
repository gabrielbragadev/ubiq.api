package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Mudança de unidade de referência, equipe ou microárea do paciente (Cadastros · Regra 4).
 */
@Entity
@Table(name = "historico_adscricao")
public class HistoricoAdscricao extends EntidadeBase {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade_id", nullable = false)
	private Unidade unidade;

	@Column(name = "equipe_id")
	private UUID equipeId;

	@Column(name = "microarea_id")
	private UUID microareaId;

	@Column(name = "vigente_desde", nullable = false)
	private LocalDate vigenteDesde;

	protected HistoricoAdscricao() {
	}

	public HistoricoAdscricao(Paciente paciente, Unidade unidade, LocalDate vigenteDesde) {
		this.paciente = paciente;
		this.unidade = unidade;
		this.vigenteDesde = vigenteDesde;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public UUID getEquipeId() {
		return equipeId;
	}

	public UUID getMicroareaId() {
		return microareaId;
	}

	public LocalDate getVigenteDesde() {
		return vigenteDesde;
	}

}
