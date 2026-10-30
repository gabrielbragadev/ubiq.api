package br.com.basetech.ubiq.api.cadastro.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UnidadeRequest(
		@NotBlank @Size(max = 255) String nome,
		@NotBlank @Pattern(regexp = "\\d{7}", message = "deve conter 7 dígitos") String cnes,
		@NotBlank @Size(max = 255) String endereco,
		@NotBlank @Size(max = 255) String horarioFuncionamento) {
}
