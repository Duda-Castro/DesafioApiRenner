package br.com.restassuredapitest.testes.users.testes;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.*;
import br.com.restassuredapitest.testes.users.requests.PostUserRequest;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

@Feature("Feature de criação de usuário")
public class PostUserTest extends BaseTest {

    PostUserRequest postUserRequest = new PostUserRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Criar um novo usuário com sucesso.")
    public void validarCriacaoDeNovoUsuario(){

        String name = new Faker().lordOfTheRings().character();
        String job = new Faker().job().position();

        postUserRequest.criaUsuario(name,job)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("size()",greaterThan(0))
                .body("name",equalTo(name))
                .body("job",equalTo(job))
                .body("id",notNullValue())
                .body("createdAt",notNullValue());
    }
}
