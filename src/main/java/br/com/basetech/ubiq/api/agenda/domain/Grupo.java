package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * Grupo ou atividade coletiva com capacidade máxima (Agenda · Regra 18).
 */
@Entity
@Table(name = "grupo")
public class Grupo extends EntidadeOperacional {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "capacidade_maxima", nullable = false)
	private int capacidadeMaxima;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_atendimento_id")
	private TipoAtendimento tipoAtendimento;

	protected Grupo() {
	}

	public Grupo(UUID unidadeId, String nome, int capacidadeMaxima) {
		super(unidadeId);
		this.nome = nome;
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public String getNome() {
		return nome;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

}
