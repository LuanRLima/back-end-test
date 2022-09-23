package br.com.oscarcalcados.testedev.service;

import br.com.oscarcalcados.testedev.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.model.Calcado;
import br.com.oscarcalcados.testedev.repository.CalcadoRepository;
import br.com.oscarcalcados.testedev.specification.CalcadoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalcadoService {

    private CalcadoRepository calcadoRepository;
    @Autowired
    private CalcadoSpecification calcadoSpecification;

    @Autowired
    public CalcadoService(CalcadoRepository calcadoRepository) {
        this.calcadoRepository = calcadoRepository;
    }

    public List<Calcado> findAll() {
        return calcadoRepository.findAll();
    }

    public Calcado findById(Long id) {
        Optional<Calcado> calcado = calcadoRepository.findById(id);
        return calcado.orElse(null);
    }

    public Page<Calcado> findAll(CalcadoFilter filter, Pageable pageable) {
        return this.calcadoRepository.findAll(this.calcadoSpecification.calcados(filter), pageable);
    }

    public Calcado save(Calcado calcado) {
        return calcadoRepository.save(calcado);
    }

    public Calcado update(Calcado calcadoUpdate, Long id) {
        Optional<Calcado> calcado = calcadoRepository.findById(id);
        if (calcado.isPresent()) {
            calcadoUpdate.setId(calcado.get().getId());
            return calcadoRepository.save(calcadoUpdate);
        }
        return calcadoRepository.save(calcadoUpdate);
    }
    public void deleteById(Long id) {
        calcadoRepository.deleteById(id);
    }
}