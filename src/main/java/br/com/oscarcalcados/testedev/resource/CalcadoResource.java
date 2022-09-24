package br.com.oscarcalcados.testedev.resource;

import br.com.oscarcalcados.testedev.dto.CalcadoFilter;
import br.com.oscarcalcados.testedev.model.Calcado;
import br.com.oscarcalcados.testedev.service.CalcadoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/calcados")
public class CalcadoResource {

    private CalcadoService calcadoService;

    @GetMapping
    public List<Calcado> findAll() {
        return this.calcadoService.findAll();
    }
    @GetMapping("/filter")
    public Page<Calcado> findAll(CalcadoFilter filter, Pageable pageable) {
        return this.calcadoService.findAll(filter, pageable);
    }
    @GetMapping("/{id}")
    public Calcado findById(@PathVariable("id")Long id) {
        return this.calcadoService.findById(id);
    }
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
    @PostMapping()
    public ResponseEntity<Calcado> save(@RequestBody Calcado calcado) {
        try {
            this.calcadoService.save(calcado);
            return new ResponseEntity<>(calcado, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
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
