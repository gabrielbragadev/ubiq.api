package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Cadastro municipal do profissional (Cadastros · Regra 8).
 */
@Entity
@Table(name = "profissional", uniqueConstraints = {
		@UniqueConstraint(name = "uk_profissional_cpf", columnNames = {"cpf"}),
		@UniqueConstraint(name = "uk_profissional_cns", columnNames = {"cns"})
})
public class Profissional extends EntidadeInativavel {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "cns", nullable = false, length = 15)
	private String cns;

	@Column(name = "conselho_numero", length = 20)
	private String conselhoNumero;

	@Column(name = "conselho_uf", length = 2)
	private String conselhoUf;

	@Column(name = "cbo", nullable = false, length = 10)
	private String cbo;

	protected Profissional() {
	}

	public Profissional(String nome, String cpf, String cns, String cbo) {
		this.nome = nome;
		this.cpf = cpf;
		this.cns = cns;
		this.cbo = cbo;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCns() {
		return cns;
	}

	public String getConselhoNumero() {
		return conselhoNumero;
	}

	public String getConselhoUf() {
		return conselhoUf;
	}

	public String getCbo() {
		return cbo;
	}

}
