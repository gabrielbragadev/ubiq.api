package br.com.basetech.ubiq.api.estoque.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Inventário geral ou rotativo de um local (Estoque · Regra 15).
 */
@Entity
@Table(name = "inventario")
public class Inventario extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "local_id", nullable = false)
	private Local local;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoInventario tipo;

	@Column(name = "iniciado_em", nullable = false)
	private Instant iniciadoEm;

	@Column(name = "concluido_em")
	private Instant concluidoEm;

	@Column(name = "aprovado_por")
	private UUID aprovadoPor;

	protected Inventario() {
	}

	public Inventario(UUID unidadeId, Local local, TipoInventario tipo, Instant iniciadoEm) {
		super(unidadeId);
		this.local = local;
		this.tipo = tipo;
		this.iniciadoEm = iniciadoEm;
	}

	public Local getLocal() {
		return local;
	}

	public TipoInventario getTipo() {
		return tipo;
	}

	public Instant getIniciadoEm() {
		return iniciadoEm;
	}

	public Instant getConcluidoEm() {
		return concluidoEm;
	}

	public UUID getAprovadoPor() {
		return aprovadoPor;
	}

}
