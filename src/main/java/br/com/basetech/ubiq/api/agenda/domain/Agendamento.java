package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

/**
 * Agendamento de um paciente em uma vaga (Agenda · Regras 7, 9, 11, 12, 15, 19 e 22).
 */
@Entity
@Table(name = "agendamento", uniqueConstraints = {
		@UniqueConstraint(name = "uk_agendamento_codigo", columnNames = {"codigo"})
})
public class Agendamento extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vaga_id", nullable = false)
	private Vaga vaga;

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Enumerated(EnumType.STRING)
	@Column(name = "canal", nullable = false, length = 40)
	private Canal canal;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusAgendamento status;

	@Column(name = "encaixe", nullable = false)
	private boolean encaixe;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agendamento_origem_id")
	private Agendamento agendamentoOrigem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tratamento_id")
	private Tratamento tratamento;

	@Column(name = "paciente_nao_vinculado", nullable = false)
	private boolean pacienteNaoVinculado = false;

	@Column(name = "cancelamento_tardio", nullable = false)
	private boolean cancelamentoTardio = false;

	protected Agendamento() {
	}

	public Agendamento(
			UUID unidadeId,
			Vaga vaga,
			UUID pacienteId,
			Canal canal,
			StatusAgendamento status,
			boolean encaixe,
			String codigo) {
		super(unidadeId);
		this.vaga = vaga;
		this.pacienteId = pacienteId;
		this.canal = canal;
		this.status = status;
		this.encaixe = encaixe;
		this.codigo = codigo;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public Canal getCanal() {
		return canal;
	}

	public StatusAgendamento getStatus() {
		return status;
	}

	public boolean isEncaixe() {
		return encaixe;
	}

	public String getCodigo() {
		return codigo;
	}

	public Agendamento getAgendamentoOrigem() {
		return agendamentoOrigem;
	}

	public Tratamento getTratamento() {
		return tratamento;
	}

	public boolean isPacienteNaoVinculado() {
		return pacienteNaoVinculado;
	}

	public boolean isCancelamentoTardio() {
		return cancelamentoTardio;
	}

}
