package br.com.basetech.ubiq.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.metamodel.EntityType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
		"spring.autoconfigure.exclude=",
		"spring.flyway.enabled=false",
		"spring.datasource.url=jdbc:h2:mem:ubiq;MODE=PostgreSQL;DB_CLOSE_DELAY=-1",
		"spring.jpa.hibernate.ddl-auto=create-drop",
		"spring.jpa.properties.hibernate.hbm2ddl.halt_on_error=true"
})
@Transactional
class MapeamentoEntidadesTests {

	private static final Set<String> ENTIDADES = Set.of(
			"Parametro", "ValorParametro", "LogAuditoria");

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void metamodeloContemTodasAsEntidades() {
		Set<String> mapeadas = entityManager.getMetamodel().getEntities().stream()
				.map(EntityType::getName)
				.collect(Collectors.toSet());

		assertThat(mapeadas).isEqualTo(ENTIDADES);
	}

}
