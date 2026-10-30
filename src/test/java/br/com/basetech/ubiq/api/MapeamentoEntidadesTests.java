package br.com.basetech.ubiq.api;

import br.com.basetech.ubiq.api.cadastro.domain.Paciente;
import br.com.basetech.ubiq.api.estoque.domain.CategoriaItem;
import br.com.basetech.ubiq.api.estoque.domain.Item;
import br.com.basetech.ubiq.api.estoque.domain.Local;
import br.com.basetech.ubiq.api.estoque.domain.Saldo;
import br.com.basetech.ubiq.api.estoque.domain.TipoLocal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.metamodel.EntityType;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
			"Parametro", "ValorParametro", "LogAuditoria", "Unidade", "Setor", "Paciente", "ResponsavelLegal",
			"HistoricoAdscricao", "Profissional", "Vinculo", "Usuario", "PerfilUnidade", "Equipe", "Microarea",
			"Domicilio", "Familia", "Tarefa", "Disponibilidade", "Afastamento", "Escala", "TurnoEscala",
			"TipoAtendimento", "Turno", "Vaga", "Agendamento", "HistoricoStatus", "Tratamento", "Grupo",
			"Inscricao", "EntradaListaEspera", "OfertaVaga", "Consentimento", "ModeloMensagem", "Mensagem",
			"MotivoFalta", "RegistroFalta", "ModeloDocumento", "Documento", "ItemReceita", "Encaminhamento",
			"Item", "Local", "Lote", "Saldo", "Movimentacao", "Requisicao", "ItemRequisicao", "Inventario",
			"Transferencia", "Receita", "Dispensacao", "Equipamento", "LeituraTemperatura", "FrascoAberto",
			"Quarentena");

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void metamodeloContemTodasAsEntidades() {
		Set<String> mapeadas = entityManager.getMetamodel().getEntities().stream()
				.map(EntityType::getName)
				.collect(Collectors.toSet());

		assertThat(mapeadas).isEqualTo(ENTIDADES);
	}

	@Test
	void gravaELePaciente() {
		Paciente paciente = new Paciente("Maria da Silva", LocalDate.of(1980, 5, 10), false);
		entityManager.persist(paciente);
		entityManager.flush();
		entityManager.clear();

		Paciente lido = entityManager.find(Paciente.class, paciente.getId());

		assertThat(lido.getNome()).isEqualTo("Maria da Silva");
		assertThat(lido.getDataNascimento()).isEqualTo(LocalDate.of(1980, 5, 10));
		assertThat(lido.getCriadoEm()).isNotNull();
		assertThat(lido.getAtualizadoEm()).isNotNull();
	}

	@Test
	void rejeitaSaldoNegativo() {
		UUID unidadeId = UUID.randomUUID();
		Item item = new Item("DIP500", "Dipirona 500 mg", "CP", CategoriaItem.MEDICAMENTO, true, false, false, false);
		Local local = new Local(unidadeId, "Farmácia", TipoLocal.FARMACIA);
		entityManager.persist(item);
		entityManager.persist(local);
		entityManager.flush();

		entityManager.persist(new Saldo(unidadeId, item, local, new BigDecimal("-1.000")));

		assertThatThrownBy(entityManager::flush)
				.isInstanceOf(ConstraintViolationException.class)
				.message().containsIgnoringCase("ck_saldo_quantidade");
	}

}
