package br.com.oscarcalcados.testedev.repository;

import br.com.oscarcalcados.testedev.domain.Calcado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório de {@link Calcado} com specifiações de busca {@link JpaSpecificationExecutor}
 */
@Repository
public interface CalcadoRepository extends JpaRepository<Calcado, Long>, JpaSpecificationExecutor<Calcado> {

    List<Calcado> findAllByOrderByIdAsc();


}

