package br.com.oscarcalcados.testedev.resource;

import br.com.oscarcalcados.testedev.domain.dto.CalcadoDTO;
import br.com.oscarcalcados.testedev.domain.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.domain.Calcado;
import br.com.oscarcalcados.testedev.service.CalcadoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Classe para mapeamento de endpoints de {@link Calcado}
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/calcados")
public class CalcadoResource {

    /**
     * Injeção de dependência para {@link CalcadoService}
     */
    @Autowired
    private ModelMapper mapper;
    /**
     * Injeção de dependência para {@link CalcadoService}
     */
    private CalcadoService calcadoService;

    /**
     * Método para buscar todos os {@link Calcado}
     * @return ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<CalcadoDTO>> findAll() {
        return ResponseEntity.ok().body(
                calcadoService.findAll()
                        .stream().map(x -> mapper.map(x, CalcadoDTO.class)).collect(Collectors.toList())
        );


    }
    /**
     * Método para buscar todos os {@link Calcado} por filtro
     * @param filter
     * @return ResponseEntity type List<Calcado>
     */
    @GetMapping("/filter")
    public List<Calcado> findAll(CalcadoFilter filter) {
        return this.calcadoService.findAllWithFilter(filter);
    }
    /**
     * Método para buscar {@link Calcado} por id
     * @param id
     * @return ResponseEntity type CalcadoDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<CalcadoDTO> findById(@PathVariable("id")Long id) {
            return ResponseEntity.ok().body(mapper.map(calcadoService.findById(id), CalcadoDTO.class));
    }
    /**
     * Método para atualizat {@link Calcado}
     * @param id, calcadoDTO
     * @return ResponseEntity type CalcadoDTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<Calcado> update(@PathVariable("id")Long id, @RequestBody Optional<Calcado> calcado) {
        try {
            if (calcado.isPresent()) {
                return new ResponseEntity<>(this.calcadoService.update(calcado.get(), id), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Método para salvar {@link Calcado}
     * @param calcado
     * @return ResponseEntity type CalcadoDTO
     */
    @PostMapping()
    public ResponseEntity<Calcado> save(@RequestBody Calcado calcado) {
        try {
            this.calcadoService.save(calcado);
            return new ResponseEntity<>(calcado, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Método para deletar {@link Calcado}
     * @param id
     * @return ResponseEntity type CalcadoDTO
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id")Long id) {
        try {
            this.calcadoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
