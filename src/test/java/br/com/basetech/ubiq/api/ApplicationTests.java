package br.com.basetech.ubiq.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.flyway.enabled=false",
		"spring.datasource.url=jdbc:h2:mem:ubiq;MODE=PostgreSQL;DB_CLOSE_DELAY=-1",
		"spring.jpa.hibernate.ddl-auto=create-drop",
		"spring.jpa.properties.hibernate.hbm2ddl.halt_on_error=true"
})
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
