package br.com.basetech.ubiq.api.seguranca.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.Instant;
import java.util.UUID;

/**
 * Conta de acesso de um profissional ou paciente (Segurança · Regras 3 e 4).
 */
@Entity
@Table(name = "usuario", uniqueConstraints = {
		@UniqueConstraint(name = "uk_usuario_login", columnNames = {"login"})
})
public class Usuario extends EntidadeInativavel {

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "senha_hash")
	private String senhaHash;

	@Column(name = "profissional_id")
	private UUID profissionalId;

	@Column(name = "paciente_id")
	private UUID pacienteId;

	@Column(name = "tentativas_falhas", nullable = false)
	private int tentativasFalhas = 0;

	@Column(name = "bloqueado_ate")
	private Instant bloqueadoAte;

	protected Usuario() {
	}

	public Usuario(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public int getTentativasFalhas() {
		return tentativasFalhas;
	}

	public Instant getBloqueadoAte() {
		return bloqueadoAte;
	}

}
