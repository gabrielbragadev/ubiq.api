package br.com.basetech.ubiq.api.documento.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeOperacional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Documento emitido, com número único e a versão do modelo usada (Documentos · Regras 3, 5 a 8 e 10).
 */
@Entity
@Table(name = "documento", uniqueConstraints = {
		@UniqueConstraint(name = "uk_documento_numero", columnNames = {"numero"})
})
public class Documento extends EntidadeOperacional {

	@Column(name = "numero", nullable = false)
	private String numero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelo_id", nullable = false)
	private ModeloDocumento modelo;

	@Column(name = "versao_modelo", nullable = false)
	private int versaoModelo;

	@Column(name = "paciente_id", nullable = false)
	private UUID pacienteId;

	@Column(name = "profissional_id", nullable = false)
	private UUID profissionalId;

	@Column(name = "conselho", nullable = false)
	private String conselho;

	@Column(name = "emitido_em", nullable = false)
	private Instant emitidoEm;

	@Column(name = "conteudo", columnDefinition = "text")
	private String conteudo;

	@Column(name = "cid_autorizado", nullable = false)
	private boolean cidAutorizado = false;

	@Column(name = "agendamento_id")
	private UUID agendamentoId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_anterior_id")
	private Documento documentoAnterior;

	@OneToMany(mappedBy = "documento")
	private List<ItemReceita> itens = new ArrayList<>();

	protected Documento() {
	}

	public Documento(
			UUID unidadeId,
			String numero,
			ModeloDocumento modelo,
			int versaoModelo,
			UUID pacienteId,
			UUID profissionalId,
			String conselho,
			Instant emitidoEm) {
		super(unidadeId);
		this.numero = numero;
		this.modelo = modelo;
		this.versaoModelo = versaoModelo;
		this.pacienteId = pacienteId;
		this.profissionalId = profissionalId;
		this.conselho = conselho;
		this.emitidoEm = emitidoEm;
	}

	public String getNumero() {
		return numero;
	}

	public ModeloDocumento getModelo() {
		return modelo;
	}

	public int getVersaoModelo() {
		return versaoModelo;
	}

	public UUID getPacienteId() {
		return pacienteId;
	}

	public UUID getProfissionalId() {
		return profissionalId;
	}

	public String getConselho() {
		return conselho;
	}

	public Instant getEmitidoEm() {
		return emitidoEm;
	}

	public String getConteudo() {
		return conteudo;
	}

	public boolean isCidAutorizado() {
		return cidAutorizado;
	}

	public UUID getAgendamentoId() {
		return agendamentoId;
	}

	public Documento getDocumentoAnterior() {
		return documentoAnterior;
	}

	public List<ItemReceita> getItens() {
		return Collections.unmodifiableList(itens);
	}

}
