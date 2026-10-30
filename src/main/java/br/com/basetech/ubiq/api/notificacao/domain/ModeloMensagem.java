package br.com.basetech.ubiq.api.notificacao.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Modelo de mensagem versionado e aprovado pela Secretaria de Saúde (Notificações · Regra 7).
 */
@Entity
@Table(name = "modelo_mensagem", uniqueConstraints = {
		@UniqueConstraint(name = "uk_modelo_mensagem_nome_versao", columnNames = {"nome", "versao"})
})
public class ModeloMensagem extends EntidadeInativavel {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "conteudo", nullable = false, columnDefinition = "text")
	private String conteudo;

	@Column(name = "versao", nullable = false)
	private int versao;

	@Column(name = "aprovado", nullable = false)
	private boolean aprovado;

	protected ModeloMensagem() {
	}

	public ModeloMensagem(String nome, String conteudo, int versao, boolean aprovado) {
		this.nome = nome;
		this.conteudo = conteudo;
		this.versao = versao;
		this.aprovado = aprovado;
	}

	public String getNome() {
		return nome;
	}

	public String getConteudo() {
		return conteudo;
	}

	public int getVersao() {
		return versao;
	}

	public boolean isAprovado() {
		return aprovado;
	}

}
