package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Cadastro municipal do paciente, sem unidade (Cadastros · Regras 1, 4, 6 e 7; Multiunidade · Regra 5).
 */
@Entity
@Table(name = "paciente", uniqueConstraints = {
		@UniqueConstraint(name = "uk_paciente_cpf", columnNames = {"cpf"}),
		@UniqueConstraint(name = "uk_paciente_cns", columnNames = {"cns"})
})
public class Paciente extends EntidadeInativavel {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "nome_social")
	private String nomeSocial;

	@Column(name = "cpf", length = 11)
	private String cpf;

	@Column(name = "cns", length = 15)
	private String cns;

	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "nome_mae")
	private String nomeMae;

	@Column(name = "celular", length = 20)
	private String celular;

	@Column(name = "provisorio", nullable = false)
	private boolean provisorio;

	@Column(name = "data_obito")
	private LocalDate dataObito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade_referencia_id")
	private Unidade unidadeReferencia;

	@Column(name = "equipe_id")
	private UUID equipeId;

	@Column(name = "microarea_id")
	private UUID microareaId;

	@Column(name = "familia_id")
	private UUID familiaId;

	protected Paciente() {
	}

	public Paciente(String nome, LocalDate dataNascimento, boolean provisorio) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.provisorio = provisorio;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCns() {
		return cns;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getCelular() {
		return celular;
	}

	public boolean isProvisorio() {
		return provisorio;
	}

	public LocalDate getDataObito() {
		return dataObito;
	}

	public Unidade getUnidadeReferencia() {
		return unidadeReferencia;
	}

	public UUID getEquipeId() {
		return equipeId;
	}

	public UUID getMicroareaId() {
		return microareaId;
	}

	public UUID getFamiliaId() {
		return familiaId;
	}

}
