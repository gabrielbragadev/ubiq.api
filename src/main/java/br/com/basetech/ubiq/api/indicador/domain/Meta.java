package br.com.basetech.ubiq.api.indicador.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.math.BigDecimal;

/**
 * Meta configurável de um indicador, com limites do semáforo (Indicadores · Regra 5).
 */
@Entity
@Table(name = "meta", uniqueConstraints = {
		@UniqueConstraint(name = "uk_meta_codigo_indicador", columnNames = {"codigo_indicador"})
})
public class Meta extends EntidadeInativavel {

	@Column(name = "codigo_indicador", nullable = false)
	private String codigoIndicador;

	@Column(name = "valor", nullable = false, precision = 15, scale = 4)
	private BigDecimal valor;

	@Column(name = "limite_verde", nullable = false, precision = 15, scale = 4)
	private BigDecimal limiteVerde;

	@Column(name = "limite_amarelo", nullable = false, precision = 15, scale = 4)
	private BigDecimal limiteAmarelo;

	protected Meta() {
	}

	public Meta(String codigoIndicador, BigDecimal valor, BigDecimal limiteVerde, BigDecimal limiteAmarelo) {
		this.codigoIndicador = codigoIndicador;
		this.valor = valor;
		this.limiteVerde = limiteVerde;
		this.limiteAmarelo = limiteAmarelo;
	}

	public String getCodigoIndicador() {
		return codigoIndicador;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getLimiteVerde() {
		return limiteVerde;
	}

	public BigDecimal getLimiteAmarelo() {
		return limiteAmarelo;
	}

}
