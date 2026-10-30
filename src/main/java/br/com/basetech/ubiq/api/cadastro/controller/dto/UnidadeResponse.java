package br.com.basetech.ubiq.api.cadastro.controller.dto;

import br.com.basetech.ubiq.api.cadastro.domain.Unidade;
import br.com.basetech.ubiq.api.shared.domain.Situacao;

import java.util.UUID;

public record UnidadeResponse(
		UUID id,
		String nome,
		String cnes,
		String endereco,
		String horarioFuncionamento,
		Situacao situacao) {

	public static UnidadeResponse de(Unidade unidade) {
		return new UnidadeResponse(unidade.getId(), unidade.getNome(), unidade.getCnes(), unidade.getEndereco(),
				unidade.getHorarioFuncionamento(), unidade.getSituacao());
	}

}
