package br.com.basetech.ubiq.api.coleta.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Resultado de uma amostra (Coleta · Regra 7).
 */
@Entity
@Table(name = "resultado")
public class Resultado extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amostra_id", nullable = false)
	private Amostra amostra;

	@Column(name = "recebido_em", nullable = false)
	private Instant recebidoEm;

	@Column(name = "critico", nullable = false)
	private boolean critico;

	@Column(name = "conteudo", columnDefinition = "text")
	private String conteudo;

	protected Resultado() {
	}

	public Resultado(UUID unidadeId, Amostra amostra, Instant recebidoEm, boolean critico) {
		super(unidadeId);
		this.amostra = amostra;
		this.recebidoEm = recebidoEm;
		this.critico = critico;
	}

	public Amostra getAmostra() {
		return amostra;
	}

	public Instant getRecebidoEm() {
		return recebidoEm;
	}

	public boolean isCritico() {
		return critico;
	}

	public String getConteudo() {
		return conteudo;
	}

}
