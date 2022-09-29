package br.com.oscarcalcados.testedev.service;

import br.com.oscarcalcados.testedev.domain.dto.CalcadoDTO;
import br.com.oscarcalcados.testedev.domain.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.domain.Calcado;
import br.com.oscarcalcados.testedev.repository.CalcadoRepository;
import br.com.oscarcalcados.testedev.service.execeptions.ObjectNotFoundException;
import br.com.oscarcalcados.testedev.specification.CalcadoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe para implementação de regras de negócio de {@link Calcado}
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */

@Service
@AllArgsConstructor
public class CalcadoService {

    /**
     * Injeção de dependência para {@link CalcadoRepository}
     */
    @Autowired
    private CalcadoRepository calcadoRepository;
    /**
     *Injecão da Classe para implementação de filtro dinamico de {@link Calcado}
     */
    @Autowired
    private CalcadoSpecification calcadoSpecification;

    /**
     * Injeção de dependência para {@link CalcadoRepository}
     */
    @Autowired
    public CalcadoService(CalcadoRepository calcadoRepository) {
        this.calcadoRepository = calcadoRepository;
    }

    /**
     * Método para buscar todos os ordenado pelo id {@link Calcado}
     * @return List
     */
    public List<Calcado> findAll() {
        return calcadoRepository.findAllByOrderByIdAsc();
    }

    /**
     * Método para buscar por id {@link Calcado}
     * @param id
     * @return Calcado
     */
    public Calcado findById(Long id) {
        Optional<Calcado> calcado = calcadoRepository.findById(id);
        return calcado.orElseThrow(() -> new ObjectNotFoundException("Calcado não encontrado! Id: " + id + ", Tipo: " + Calcado.class.getName()));
    }
    /**
     * Método para buscar todos os {@link Calcado} por filtro
     * @param filter
     * @return List<Calcado>
     */
    public List<Calcado> findAllWithFilter(CalcadoFilter filter) {
        return this.calcadoRepository.findAll(this.calcadoSpecification.calcados(filter));
    }

    /**
     * Método para salvar {@link Calcado}
     * @param calcado
     * @return Calcado
     */
    public Calcado save(Calcado calcado) {
        return calcadoRepository.save(calcado);
    }

    /**
     * Método para atualizar {@link Calcado}
     * @param calcadoUpdate, id
     * @return Calcado
     */
    public Calcado update(Calcado calcadoUpdate, Long id) {
        Calcado calcado = findById(id);
        System.out.println(calcado);
        calcado.setNome(calcadoUpdate.getNome());
        calcado.setMarca(calcadoUpdate.getMarca());
        calcado.setCor(calcadoUpdate.getCor());
        calcado.setTamanho(calcadoUpdate.getTamanho());
        calcado.setPreco(calcadoUpdate.getPreco());
        calcado.setQuantidadeEmEstoque(calcadoUpdate.getQuantidadeEmEstoque());
        calcado.setCategoria(calcadoUpdate.getCategoria());
        calcado.setDescricao(calcadoUpdate.getDescricao());
        return calcadoRepository.save(calcado);
    }
    /**
     * Método para deletar {@link Calcado}
     * @param id
     */
    public void deleteById(Long id) {
        calcadoRepository.deleteById(id);
    }
}