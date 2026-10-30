package br.com.basetech.ubiq.api.agenda.domain;

import br.com.basetech.ubiq.api.shared.domain.EntidadeInativavel;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Tipo de atendimento municipal (Agenda · Regra 1).
 */
@Entity
@Table(name = "tipo_atendimento")
public class TipoAtendimento extends EntidadeInativavel {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "categoria_cbo", nullable = false, length = 10)
	private String categoriaCbo;

	@Column(name = "duracao_minutos", nullable = false)
	private int duracaoMinutos;

	@Enumerated(EnumType.STRING)
	@Column(name = "modalidade", nullable = false, length = 40)
	private Modalidade modalidade;

	@Column(name = "exige_encaminhamento", nullable = false)
	private boolean exigeEncaminhamento;

	@ElementCollection
	@CollectionTable(name = "tipo_atendimento_canais", joinColumns = @JoinColumn(name = "tipo_atendimento_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "canai", nullable = false, length = 40)
	private Set<Canal> canais = new HashSet<>();

	@Column(name = "publico_alvo")
	private String publicoAlvo;

	protected TipoAtendimento() {
	}

	public TipoAtendimento(
			String nome,
			String categoriaCbo,
			int duracaoMinutos,
			Modalidade modalidade,
			boolean exigeEncaminhamento,
			Set<Canal> canais) {
		this.nome = nome;
		this.categoriaCbo = categoriaCbo;
		this.duracaoMinutos = duracaoMinutos;
		this.modalidade = modalidade;
		this.exigeEncaminhamento = exigeEncaminhamento;
		this.canais = new HashSet<>(canais);
	}

	public String getNome() {
		return nome;
	}

	public String getCategoriaCbo() {
		return categoriaCbo;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public boolean isExigeEncaminhamento() {
		return exigeEncaminhamento;
	}

	public Set<Canal> getCanais() {
		return Collections.unmodifiableSet(canais);
	}

	public String getPublicoAlvo() {
		return publicoAlvo;
	}

}
