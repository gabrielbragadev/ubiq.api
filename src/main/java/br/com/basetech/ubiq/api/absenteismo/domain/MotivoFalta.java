package br.com.basetech.ubiq.api.absenteismo.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Item da lista padronizada de motivos de falta (Absenteísmo · Regra 6).
 */
@Entity
@Table(name = "motivo_falta", uniqueConstraints = {
		@UniqueConstraint(name = "uk_motivo_falta_descricao", columnNames = {"descricao"})
})
public class MotivoFalta extends EntidadeInativavel {

	@Column(name = "descricao", nullable = false)
	private String descricao;

	protected MotivoFalta() {
	}

	public MotivoFalta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
