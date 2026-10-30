package br.com.basetech.ubiq.api.shared.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

/**
 * Valor de um parâmetro em uma unidade.
 */
@Entity
@Table(name = "valor_parametro", uniqueConstraints = {
		@UniqueConstraint(name = "uk_valor_parametro_unidade", columnNames = {"parametro_id", "unidade_id"})
})
public class ValorParametro extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parametro_id", nullable = false)
	private Parametro parametro;

	@Column(name = "valor", nullable = false, columnDefinition = "text")
	private String valor;

	protected ValorParametro() {
	}

	public ValorParametro(UUID unidadeId, Parametro parametro, String valor) {
		super(unidadeId);
		this.parametro = parametro;
		this.valor = valor;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public String getValor() {
		return valor;
	}

}
