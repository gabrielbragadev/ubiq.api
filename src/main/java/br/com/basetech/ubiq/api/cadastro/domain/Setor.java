package br.com.basetech.ubiq.api.cadastro.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Setor de uma unidade, que pode estar habilitado ou não (Cadastros · Regra 10).
 */
@Entity
@Table(name = "setor", uniqueConstraints = {
		@UniqueConstraint(name = "uk_setor_unidade_tipo", columnNames = {"unidade_id", "tipo"})
})
public class Setor extends EntidadeInativavel {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unidade_id", nullable = false)
	private Unidade unidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoSetor tipo;

	@Column(name = "habilitado", nullable = false)
	private boolean habilitado;

	protected Setor() {
	}

	public Setor(Unidade unidade, TipoSetor tipo, boolean habilitado) {
		this.unidade = unidade;
		this.tipo = tipo;
		this.habilitado = habilitado;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public TipoSetor getTipo() {
		return tipo;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

}
