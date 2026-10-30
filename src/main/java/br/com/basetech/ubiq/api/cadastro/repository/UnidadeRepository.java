package br.com.basetech.ubiq.api.cadastro.repository;

import br.com.basetech.ubiq.api.cadastro.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UnidadeRepository extends JpaRepository<Unidade, UUID> {

	List<Unidade> findAllByOrderByNomeAsc();

	boolean existsByCnes(String cnes);

	boolean existsByCnesAndIdNot(String cnes, UUID id);

}
