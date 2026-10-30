package br.com.basetech.ubiq.api.listaespera.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;

import java.time.Instant;
import java.util.UUID;

/**
 * Entrada de um paciente na lista, por tipo de atendimento e unidade (Lista de espera · Regras 1, 2 e 5).
 */
@Entity
@Table(name = "entrada_lista_espera")
@Check(name = "ck_entrada_lista_espera_motivo_saida", constraints = "situacao = 'ATIVO' or motivo_saida is not null")
public class EntradaListaEspera extends EntidadeOperacional {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Column(name = "tipo_atendimento_id", nullable = false)
	private UUID tipoAtendimentoId;

	@Column(name = "prioridade", nullable = false)
	private int prioridade;

	@Column(name = "data_entrada", nullable = false)
	private Instant dataEntrada;

	@Enumerated(EnumType.STRING)
	@Column(name = "motivo_saida", length = 40)
	private MotivoSaida motivoSaida;

	protected EntradaListaEspera() {
	}

	public EntradaListaEspera(
			UUID unidadeId,
			UUID pacienteId,
			UUID tipoAtendimentoId,
			int prioridade,
			Instant dataEntrada) {
		super(unidadeId);
		this.pacienteId = pacienteId;
		this.tipoAtendimentoId = tipoAtendimentoId;
		this.prioridade = prioridade;
		this.dataEntrada = dataEntrada;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public UUID getTipoAtendimentoId() {
		return tipoAtendimentoId;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public Instant getDataEntrada() {
		return dataEntrada;
	}

	public MotivoSaida getMotivoSaida() {
		return motivoSaida;
	}

}
