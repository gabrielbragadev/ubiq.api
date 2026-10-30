package br.com.basetech.ubiq.api.farmacia.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Receita emitida no módulo Documentos ou externa (Farmácia · Regras 1, 2 e 5).
 */
@Entity
@Table(name = "receita")
public class Receita extends EntidadeOperacional {

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Enumerated(EnumType.STRING)
	@Column(name = "origem", nullable = false, length = 40)
	private OrigemReceita origem;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 40)
	private TipoReceita tipo;

	@Column(name = "documento_id")
	private UUID documentoId;

	@Column(name = "prescritor", nullable = false)
	private String prescritor;

	@Column(name = "conselho", nullable = false)
	private String conselho;

	@Column(name = "data", nullable = false)
	private LocalDate data;

	@Column(name = "retida", nullable = false)
	private boolean retida = false;

	protected Receita() {
	}

	public Receita(
			UUID unidadeId,
			UUID pacienteId,
			OrigemReceita origem,
			TipoReceita tipo,
			String prescritor,
			String conselho,
			LocalDate data) {
		super(unidadeId);
		this.pacienteId = pacienteId;
		this.origem = origem;
		this.tipo = tipo;
		this.prescritor = prescritor;
		this.conselho = conselho;
		this.data = data;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public OrigemReceita getOrigem() {
		return origem;
	}

	public TipoReceita getTipo() {
		return tipo;
	}

	public UUID getDocumentoId() {
		return documentoId;
	}

	public String getPrescritor() {
		return prescritor;
	}

	public String getConselho() {
		return conselho;
	}

	public LocalDate getData() {
		return data;
	}

	public boolean isRetida() {
		return retida;
	}

}
