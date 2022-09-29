package br.com.oscarcalcados.testedev.resource.exception;

import br.com.oscarcalcados.testedev.service.execeptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
/**
 * Classe para tratamento de exceções
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    /**
     * Método para tratar exceção de objeto não encontrado
     * @param e
     * @param request
     * @return ResponseEntity
     */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
