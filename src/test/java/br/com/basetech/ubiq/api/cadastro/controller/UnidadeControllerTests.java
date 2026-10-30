package br.com.basetech.ubiq.api.cadastro.controller;

import br.com.basetech.ubiq.api.cadastro.domain.Unidade;
import br.com.basetech.ubiq.api.cadastro.repository.UnidadeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Filtros desligados até a segurança da API existir (T-026).
@SpringBootTest(properties = {
		"spring.flyway.enabled=false",
		"spring.datasource.url=jdbc:h2:mem:ubiq_unidade;MODE=PostgreSQL;DB_CLOSE_DELAY=-1",
		"spring.jpa.hibernate.ddl-auto=create-drop",
		"spring.jpa.properties.hibernate.hbm2ddl.halt_on_error=true"
})
@AutoConfigureMockMvc(addFilters = false)
@Transactional
class UnidadeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UnidadeRepository unidades;

	private static String corpo(String cnes) {
		return """
				{"nome": "UBS Centro", "cnes": "%s", "endereco": "Rua A, 10", "horarioFuncionamento": "07h às 17h"}
				""".formatted(cnes);
	}

	private Unidade existente(String cnes) {
		return unidades.saveAndFlush(new Unidade("UBS Norte", cnes, "Rua B, 20", "08h às 18h"));
	}

	@Test
	void criaUnidade() throws Exception {
		mockMvc.perform(post("/unidades").contentType(MediaType.APPLICATION_JSON).content(corpo("1234567")))
				.andExpect(status().isCreated())
				.andExpect(header().string("Location", startsWith("/unidades/")))
				.andExpect(jsonPath("$.id").isNotEmpty())
				.andExpect(jsonPath("$.cnes").value("1234567"))
				.andExpect(jsonPath("$.situacao").value("ATIVO"));
	}

	@Test
	void rejeitaCnesInvalido() throws Exception {
		mockMvc.perform(post("/unidades").contentType(MediaType.APPLICATION_JSON).content(corpo("123")))
				.andExpect(status().isBadRequest());
	}

	@Test
	void rejeitaCnesRepetidoAoCriar() throws Exception {
		existente("1234567");

		mockMvc.perform(post("/unidades").contentType(MediaType.APPLICATION_JSON).content(corpo("1234567")))
				.andExpect(status().isConflict());
	}

	@Test
	void listaUnidades() throws Exception {
		Unidade unidade = existente("1234567");

		mockMvc.perform(get("/unidades"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(unidade.getId().toString()));
	}

	@Test
	void buscaUnidadePorId() throws Exception {
		Unidade unidade = existente("1234567");

		mockMvc.perform(get("/unidades/{id}", unidade.getId()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome").value("UBS Norte"));
	}

	@Test
	void retornaNaoEncontradoParaUnidadeInexistente() throws Exception {
		mockMvc.perform(get("/unidades/{id}", UUID.randomUUID()))
				.andExpect(status().isNotFound());
	}

	@Test
	void atualizaUnidadeMantendoOProprioCnes() throws Exception {
		Unidade unidade = existente("1234567");

		mockMvc.perform(put("/unidades/{id}", unidade.getId()).contentType(MediaType.APPLICATION_JSON).content(corpo("1234567")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome").value("UBS Centro"));
	}

	@Test
	void rejeitaCnesDeOutraUnidadeAoAtualizar() throws Exception {
		existente("1234567");
		Unidade unidade = existente("7654321");

		mockMvc.perform(put("/unidades/{id}", unidade.getId()).contentType(MediaType.APPLICATION_JSON).content(corpo("1234567")))
				.andExpect(status().isConflict());
	}

}
