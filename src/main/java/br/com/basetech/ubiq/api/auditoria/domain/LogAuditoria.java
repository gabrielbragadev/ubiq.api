package br.com.basetech.ubiq.api.auditoria.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Registro append-only de quem fez o quê e quando (LGPD · Regras 2, 3 e 5).
 */
@Entity
@Table(name = "log_auditoria")
public class LogAuditoria extends EntidadeBase {

	@Column(name = "ocorrido_em", nullable = false)
	private Instant ocorridoEm;

	@Column(name = "usuario_id")
	private UUID usuarioId;

	@Column(name = "unidade_id")
	private UUID unidadeId;

	@Enumerated(EnumType.STRING)
	@Column(name = "acao", nullable = false, length = 40)
	private AcaoAuditoria acao;

	@Column(name = "recurso", nullable = false)
	private String recurso;

	@Column(name = "ip", length = 45)
	private String ip;

	@Column(name = "motivo")
	private String motivo;

	protected LogAuditoria() {
	}

	public LogAuditoria(Instant ocorridoEm, AcaoAuditoria acao, String recurso) {
		this.ocorridoEm = ocorridoEm;
		this.acao = acao;
		this.recurso = recurso;
	}

	public Instant getOcorridoEm() {
		return ocorridoEm;
	}

	public UUID getUsuarioId() {
		return usuarioId;
	}

	public UUID getUnidadeId() {
		return unidadeId;
	}

	public AcaoAuditoria getAcao() {
		return acao;
	}

	public String getRecurso() {
		return recurso;
	}

	public String getIp() {
		return ip;
	}

	public String getMotivo() {
		return motivo;
	}

}
