package br.com.oscarcalcados.testedev.resource;

import br.com.oscarcalcados.testedev.domain.Calcado;
import br.com.oscarcalcados.testedev.resource.exception.StandardError;
import br.com.oscarcalcados.testedev.service.execeptions.ObjectNotFoundException;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import io.restassured.RestAssured;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static br.com.oscarcalcados.testedev.domain.Categoria.TENIS;

/**
 * Classe responsável por testar os endpoints da classe CalcadoResource
 *
 * @author Luan Rodrigues
 * @version 1.0
 * @since 2021-05-10
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalcadoResourceTest extends AbstractContainerBase {


    /**
     * Porta do servidor
     */
    @LocalServerPort
    private int randomPort;
    /**
     * Caminho do endpoint
     */
    @BeforeEach
    void setUp() {
        RestAssured.port = randomPort;
    }
    /**
     * Método responsável por testar o endpoint de buscar todos os calçados
     */
    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/calcados")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    /**
     * Método responsável por testar o endpoint de buscar todos os calçados com filtro dinamico
     */
    @Test
    void whenFindAllWithFilterThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/calcados/filter?nome=tenis&cor=preto&marca=adidas&tamanho=40&valor=100")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    /**
     * Método responsável por testar o endpoint de buscar um calçado por id
     */
    @Test
    void whenFindByIdThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/calcados/1")
                .then()
                .extract().response().prettyPrint();
    }

    /**
     * Método responsável por testar o endpoint de criar um calçado
     */
    @Test
    void whenCreateThenCheckResult() {
        Calcado calcado = new Calcado("Tênis", "Nike", "Preto", "40", 100.00, 1, TENIS, "tenis nike preto");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(calcado)
                .when()
                .post("/api/calcados")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    /**
     * Método responsável por testar o endpoint de atualizar um calçado
     */
    @Test
    void whenUpdateThenCheckResult() {
        Calcado calcado = new Calcado("Tênis", "Nike", "Preto", "40", 100.00, 1, TENIS, "tenis nike preto");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(calcado)
                .when()
                .put("/api/calcados/1")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    /**
     * Método responsável por testar o endpoint de deletar um calçado
     */
    @Test
    void whenDeleteThenCheckResult() {
        RestAssured.given()
                .when()
                .delete("/api/calcados/1")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }


}