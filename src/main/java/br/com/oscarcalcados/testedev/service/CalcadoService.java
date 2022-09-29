package br.com.oscarcalcados.testedev.service;

import br.com.oscarcalcados.testedev.domain.dto.CalcadoDTO;
import br.com.oscarcalcados.testedev.domain.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.domain.Calcado;
import br.com.oscarcalcados.testedev.repository.CalcadoRepository;
import br.com.oscarcalcados.testedev.specification.CalcadoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalcadoService {

    @Autowired
    private CalcadoRepository calcadoRepository;
    @Autowired
    private CalcadoSpecification calcadoSpecification;

    @Autowired
    public CalcadoService(CalcadoRepository calcadoRepository) {
        this.calcadoRepository = calcadoRepository;
    }

    public List<Calcado> findAll() {
        return calcadoRepository.findAllByOrderByIdAsc();
    }

    public Calcado findById(Long id) {
        Optional<Calcado> calcado = calcadoRepository.findById(id);
        return calcado.orElse(null);
    }

    public List<Calcado> findAllWithFilter(CalcadoFilter filter) {
        return this.calcadoRepository.findAll(this.calcadoSpecification.calcados(filter));
    }

    public Calcado save(Calcado calcado) {
        return calcadoRepository.save(calcado);
    }

    public Calcado update(Calcado calcadoUpdate, Long id) {
        Calcado calcado = findById(id);
        if (calcado != null) {
            calcado.setNome(calcadoUpdate.getNome());
            calcado.setMarca(calcadoUpdate.getMarca());
            calcado.setCor(calcadoUpdate.getCor());
            calcado.setTamanho(calcadoUpdate.getTamanho());
            calcado.setPreco(calcadoUpdate.getPreco());
            calcadoRepository.save(calcado);
        }
        return calcado;
    }
    public void deleteById(Long id) {
        calcadoRepository.deleteById(id);
    }
}