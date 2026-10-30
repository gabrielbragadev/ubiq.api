package br.com.basetech.ubiq.api.cadastro.service;

import br.com.basetech.ubiq.api.cadastro.controller.dto.UnidadeRequest;
import br.com.basetech.ubiq.api.cadastro.domain.Unidade;
import br.com.basetech.ubiq.api.cadastro.repository.UnidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UnidadeService {

	private final UnidadeRepository unidades;

	public UnidadeService(UnidadeRepository unidades) {
		this.unidades = unidades;
	}

	@Transactional(readOnly = true)
	public List<Unidade> listar() {
		return unidades.findAllByOrderByNomeAsc();
	}

	@Transactional(readOnly = true)
	public Unidade buscar(UUID id) {
		return unidades.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unidade não encontrada"));
	}

	@Transactional
	public Unidade criar(UnidadeRequest dados) {
		if (unidades.existsByCnes(dados.cnes())) {
			throw cnesJaCadastrado();
		}
		return unidades.save(new Unidade(dados.nome(), dados.cnes(), dados.endereco(), dados.horarioFuncionamento()));
	}

	@Transactional
	public Unidade atualizar(UUID id, UnidadeRequest dados) {
		Unidade unidade = buscar(id);
		if (unidades.existsByCnesAndIdNot(dados.cnes(), id)) {
			throw cnesJaCadastrado();
		}
		unidade.atualizar(dados.nome(), dados.cnes(), dados.endereco(), dados.horarioFuncionamento());
		return unidade;
	}

	private ResponseStatusException cnesJaCadastrado() {
		return new ResponseStatusException(HttpStatus.CONFLICT, "CNES já cadastrado");
	}

}
