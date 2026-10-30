package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Responsável legal de menor ou pessoa sob curatela (Cadastros · Regra 5).
 */
@Entity
@Table(name = "responsavel_legal")
public class ResponsavelLegal extends EntidadeInativavel {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", length = 11)
	private String cpf;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paciente_responsavel_id")
	private Paciente pacienteResponsavel;

	protected ResponsavelLegal() {
	}

	public ResponsavelLegal(Paciente paciente, String nome) {
		this.paciente = paciente;
		this.nome = nome;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Paciente getPacienteResponsavel() {
		return pacienteResponsavel;
	}

}
