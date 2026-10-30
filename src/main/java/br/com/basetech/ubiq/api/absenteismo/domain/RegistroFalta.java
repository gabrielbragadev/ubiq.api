package br.com.basetech.ubiq.api.absenteismo.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Falta no histórico do paciente (Absenteísmo · Regras 1, 6 e 7).
 */
@Entity
@Table(name = "registro_falta")
public class RegistroFalta extends EntidadeOperacional {

	@Column(name = "agendamento_id", nullable = false)
	private UUID agendamentoId;

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Column(name = "data", nullable = false)
	private LocalDate data;

	@Column(name = "tipo_atendimento_id", nullable = false)
	private UUID tipoAtendimentoId;

	@Column(name = "justificada", nullable = false)
	private boolean justificada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motivo_id")
	private MotivoFalta motivo;

	protected RegistroFalta() {
	}

	public RegistroFalta(
			UUID unidadeId,
			UUID agendamentoId,
			UUID pacienteId,
			LocalDate data,
			UUID tipoAtendimentoId,
			boolean justificada) {
		super(unidadeId);
		this.agendamentoId = agendamentoId;
		this.pacienteId = pacienteId;
		this.data = data;
		this.tipoAtendimentoId = tipoAtendimentoId;
		this.justificada = justificada;
	}

	public UUID getAgendamentoId() {
		return agendamentoId;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public LocalDate getData() {
		return data;
	}

	public UUID getTipoAtendimentoId() {
		return tipoAtendimentoId;
	}

	public boolean isJustificada() {
		return justificada;
	}

	public MotivoFalta getMotivo() {
		return motivo;
	}

}
