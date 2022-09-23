package br.com.oscarcalcados.testedev.service;

import br.com.oscarcalcados.testedev.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.model.Calcado;
import br.com.oscarcalcados.testedev.repository.CalcadoRepository;
import br.com.oscarcalcados.testedev.specification.CalcadoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalcadoService {

    private CalcadoRepository calcadoRepository;
    private CalcadoSpecification calcadoSpecification;

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
        Calcado calcado = findById(id);
        calcado.setNome(calcadoUpdate.getNome());
        calcado.setMarca(calcadoUpdate.getMarca());
        calcado.setCor(calcadoUpdate.getCor());
        calcado.setTamanho(calcadoUpdate.getTamanho());
        calcado.setPreco(calcadoUpdate.getPreco());
        calcado.setQuantidadeEmEstoque(calcadoUpdate.getQuantidadeEmEstoque());
        return calcadoRepository.save(calcado);

    }
}