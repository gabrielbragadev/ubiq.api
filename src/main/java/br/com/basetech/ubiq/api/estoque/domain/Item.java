package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.Check;

/**
 * Item do catálogo municipal (Estoque · Regra 1; Farmácia · Regra 5).
 */
@Entity
@Table(name = "item", uniqueConstraints = {
		@UniqueConstraint(name = "uk_item_codigo", columnNames = {"codigo"})
})
@Check(name = "ck_item_controla_lote", constraints = "controla_lote or (not esteril and categoria not in ('MEDICAMENTO', 'IMUNOBIOLOGICO'))")
public class Item extends EntidadeInativavel {

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "unidade_medida", nullable = false)
	private String unidadeMedida;

	@Enumerated(EnumType.STRING)
	@Column(name = "categoria", nullable = false, length = 40)
	private CategoriaItem categoria;

	@Column(name = "controla_lote", nullable = false)
	private boolean controlaLote;

	@Column(name = "esteril", nullable = false)
	private boolean esteril;

	@Column(name = "critico", nullable = false)
	private boolean critico;

	@Column(name = "controle_especial", nullable = false)
	private boolean controleEspecial;

	protected Item() {
	}

	public Item(
			String codigo,
			String descricao,
			String unidadeMedida,
			CategoriaItem categoria,
			boolean controlaLote,
			boolean esteril,
			boolean critico,
			boolean controleEspecial) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.categoria = categoria;
		this.controlaLote = controlaLote;
		this.esteril = esteril;
		this.critico = critico;
		this.controleEspecial = controleEspecial;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public CategoriaItem getCategoria() {
		return categoria;
	}

	public boolean isControlaLote() {
		return controlaLote;
	}

	public boolean isEsteril() {
		return esteril;
	}

	public boolean isCritico() {
		return critico;
	}

	public boolean isControleEspecial() {
		return controleEspecial;
	}

}
