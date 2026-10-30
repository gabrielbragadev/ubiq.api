package br.com.basetech.ubiq.api.integracao.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

/**
 * Envio guardado na fila de reprocessamento (Integrações · Regra 9).
 */
@Entity
@Table(name = "outbox_evento")
public class OutboxEvento extends EntidadeBase {

	@Column(name = "destino", nullable = false)
	private String destino;

	@Column(name = "conteudo", nullable = false, columnDefinition = "text")
	private String conteudo;

	@Column(name = "tentativas", nullable = false)
	private int tentativas = 0;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 40)
	private StatusOutbox status;

	protected OutboxEvento() {
	}

	public OutboxEvento(String destino, String conteudo, StatusOutbox status) {
		this.destino = destino;
		this.conteudo = conteudo;
		this.status = status;
	}

	public String getDestino() {
		return destino;
	}

	public String getConteudo() {
		return conteudo;
	}

	public int getTentativas() {
		return tentativas;
	}

	public StatusOutbox getStatus() {
		return status;
	}

}
