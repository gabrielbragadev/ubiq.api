package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Mudança de status de um agendamento (Agenda · Regra 11).
 */
@Entity
@Table(name = "historico_status")
public class HistoricoStatus extends EntidadeBase {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agendamento_id", nullable = false)
	private Agendamento agendamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_anterior", length = 40)
	private StatusAgendamento statusAnterior;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_novo", nullable = false, length = 40)
	private StatusAgendamento statusNovo;

	@Column(name = "motivo")
	private String motivo;

	protected HistoricoStatus() {
	}

	public HistoricoStatus(Agendamento agendamento, StatusAgendamento statusNovo) {
		this.agendamento = agendamento;
		this.statusNovo = statusNovo;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public StatusAgendamento getStatusAnterior() {
		return statusAnterior;
	}

	public StatusAgendamento getStatusNovo() {
		return statusNovo;
	}

	public String getMotivo() {
		return motivo;
	}

}
