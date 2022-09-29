package br.com.oscarcalcados.testedev.resource;

import org.testcontainers.containers.PostgreSQLContainer;


/**
 * Classe responsável por gerenciar o container do banco de dados
 *
 * @author Luan Rodrigues
 * @version 1.0
 * @since 2021-05-10
 */
public abstract class AbstractContainerBase {


    /**
     * Método responsável por iniciar o container do banco de dados
     *
     * @return PostgreSQLContainer
     */
    static final PostgreSQLContainer POSTGRE_SQL_CONTAINER;

    // Inicializando o container do banco de dados para teste

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:10-alpine");
        POSTGRE_SQL_CONTAINER.start();
        System.setProperty("spring.datasource.url", POSTGRE_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRE_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", POSTGRE_SQL_CONTAINER.getPassword());
    }
}