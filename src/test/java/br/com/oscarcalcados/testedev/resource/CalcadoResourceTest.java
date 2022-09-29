package br.com.oscarcalcados.testedev.resource;

import br.com.oscarcalcados.testedev.domain.Calcado;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import io.restassured.RestAssured;

import static br.com.oscarcalcados.testedev.domain.Categoria.TENIS;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalcadoResourceTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    void setUp() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/calcados")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void whenFindAllWithFilterThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/calcados/filter?nome=tenis&cor=preto&marca=adidas&tamanho=40&valor=100")
                .then()
                .statusCode(HttpStatus.OK.value());
    }


    @Test
    void whenFindByIdThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/api/calcados/1")
                .then()
                .statusCode(HttpStatus.OK.value());
    }


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

    @Test
    void whenDeleteThenCheckResult() {
        RestAssured.given()
                .when()
                .delete("/api/calcados/1")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }
}