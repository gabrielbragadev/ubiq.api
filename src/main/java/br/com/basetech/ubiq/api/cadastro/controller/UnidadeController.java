package br.com.basetech.ubiq.api.cadastro.controller;

import br.com.basetech.ubiq.api.cadastro.controller.dto.UnidadeRequest;
import br.com.basetech.ubiq.api.cadastro.controller.dto.UnidadeResponse;
import br.com.basetech.ubiq.api.cadastro.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

	private final UnidadeService service;

	public UnidadeController(UnidadeService service) {
		this.service = service;
	}

	@GetMapping
	public List<UnidadeResponse> listar() {
		return service.listar().stream().map(UnidadeResponse::de).toList();
	}

	@GetMapping("/{id}")
	public UnidadeResponse buscar(@PathVariable UUID id) {
		return UnidadeResponse.de(service.buscar(id));
	}

	@PostMapping
	public ResponseEntity<UnidadeResponse> criar(@Valid @RequestBody UnidadeRequest dados) {
		UnidadeResponse criada = UnidadeResponse.de(service.criar(dados));
		return ResponseEntity.created(URI.create("/unidades/" + criada.id())).body(criada);
	}

	@PutMapping("/{id}")
	public UnidadeResponse atualizar(@PathVariable UUID id, @Valid @RequestBody UnidadeRequest dados) {
		return UnidadeResponse.de(service.atualizar(id, dados));
	}

}
