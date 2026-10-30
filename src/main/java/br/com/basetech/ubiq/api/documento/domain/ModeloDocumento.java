package br.com.basetech.ubiq.api.documento.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Modelo versionado criado pela Secretaria de Saúde (Documentos · Regras 2 e 3).
 */
@Entity
@Table(name = "modelo_documento", uniqueConstraints = {
		@UniqueConstraint(name = "uk_modelo_documento_tipo_versao", columnNames = {"tipo", "versao"})
})
public class ModeloDocumento extends EntidadeInativavel {

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoDocumento tipo;

	@Column(name = "versao", nullable = false)
	private int versao;

	@Column(name = "conteudo", nullable = false, columnDefinition = "text")
	private String conteudo;

	protected ModeloDocumento() {
	}

	public ModeloDocumento(TipoDocumento tipo, int versao, String conteudo) {
		this.tipo = tipo;
		this.versao = versao;
		this.conteudo = conteudo;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public int getVersao() {
		return versao;
	}

	public String getConteudo() {
		return conteudo;
	}

}
