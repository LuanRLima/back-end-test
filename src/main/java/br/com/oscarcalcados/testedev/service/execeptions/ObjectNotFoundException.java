package br.com.oscarcalcados.testedev.service.execeptions;
/**
 * Classe para exceção de objeto não encontrado
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
