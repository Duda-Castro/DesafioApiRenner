package br.com.restassuredapitest.testes.users.testes;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.testes.users.requests.GetSingleUserRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

@Feature("Feature de pesquisa de usuario singular")
public class GetSingleUserTest extends BaseTest {
    GetSingleUserRequest getSingleUserRequest = new GetSingleUserRequest();


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Retornar um usuário específico.")
    public void validarBuscaDeUsuarioPorId(){
        int id = 11;
        getSingleUserRequest.userById(id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id",equalTo(id))
                .body("data.email",equalTo("george.edwards@reqres.in"))
                .body("data.first_name",equalTo("George"))
                .body("data.last_name",equalTo("Edwards"))
                .body("data.avatar",equalTo("https://reqres.in/img/faces/11-image.jpg"));

    }
}
