package br.com.basetech.ubiq.api.seguranca.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

/**
 * Perfil de um usuário em uma unidade (Segurança · Regra 1).
 */
@Entity
@Table(name = "perfil_unidade", uniqueConstraints = {
		@UniqueConstraint(name = "uk_perfil_unidade", columnNames = {"usuario_id", "unidade_id", "perfil"})
})
public class PerfilUnidade extends EntidadeOperacional {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false, length = 40)
	private Perfil perfil;

	protected PerfilUnidade() {
	}

	public PerfilUnidade(UUID unidadeId, Usuario usuario, Perfil perfil) {
		super(unidadeId);
		this.usuario = usuario;
		this.perfil = perfil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

}
