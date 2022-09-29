package br.com.oscarcalcados.testedev.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do ModelMapper
 *
 * @author Luan Rodrigues
 * @since 1.0 (10/09/2020)
 */
@Configuration
public class ModelMapperConfig {
    /**
     * Cria um bean do ModelMapper
     *
     * @return ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
