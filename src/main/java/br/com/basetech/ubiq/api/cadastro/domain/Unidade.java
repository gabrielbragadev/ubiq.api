package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Unidade de saúde, cadastrada pela Secretaria de Saúde (Cadastros · Regra 10).
 */
@Entity
@Table(name = "unidade", uniqueConstraints = {
		@UniqueConstraint(name = "uk_unidade_cnes", columnNames = {"cnes"})
})
public class Unidade extends EntidadeInativavel {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cnes", nullable = false, length = 7)
	private String cnes;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "horario_funcionamento", nullable = false)
	private String horarioFuncionamento;

	protected Unidade() {
	}

	public Unidade(String nome, String cnes, String endereco, String horarioFuncionamento) {
		this.nome = nome;
		this.cnes = cnes;
		this.endereco = endereco;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public String getNome() {
		return nome;
	}

	public String getCnes() {
		return cnes;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

}
