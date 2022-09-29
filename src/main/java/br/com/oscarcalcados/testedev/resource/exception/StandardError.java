package br.com.oscarcalcados.testedev.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
/**
 * Classe personalizada para erros
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */
@Getter
@Setter
@AllArgsConstructor
public class StandardError {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
