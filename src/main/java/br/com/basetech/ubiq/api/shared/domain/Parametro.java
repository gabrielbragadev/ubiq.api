package br.com.basetech.ubiq.api.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Parâmetro com valor padrão municipal, que pode ser sobrescrito por unidade (Regras gerais · Regra 4).
 */
@Entity
@Table(name = "parametro", uniqueConstraints = {
		@UniqueConstraint(name = "uk_parametro_chave", columnNames = {"chave"})
})
public class Parametro extends EntidadeInativavel {

	@Column(name = "chave", nullable = false)
	private String chave;

	@Column(name = "valor_padrao", nullable = false, columnDefinition = "text")
	private String valorPadrao;

	@Column(name = "por_unidade", nullable = false)
	private boolean porUnidade;

	protected Parametro() {
	}

	public Parametro(String chave, String valorPadrao, boolean porUnidade) {
		this.chave = chave;
		this.valorPadrao = valorPadrao;
		this.porUnidade = porUnidade;
	}

	public String getChave() {
		return chave;
	}

	public String getValorPadrao() {
		return valorPadrao;
	}

	public boolean isPorUnidade() {
		return porUnidade;
	}

}
