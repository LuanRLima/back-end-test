package br.com.oscarcalcados.testedev.repository;

import br.com.oscarcalcados.testedev.model.Calcado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcadoRepository extends JpaRepository<Calcado, Long>, JpaSpecificationExecutor<Calcado> {

}

