package br.com.restassuredapitest.testes.users.testes;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.testes.users.requests.GetListUsersRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

@Feature("Feature de busca de lista de usuarios")
public class GetListUsersTest extends BaseTest {

    GetListUsersRequest getListUsersRequest = new GetListUsersRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Busca lista de usuarios.")
    public void buscaListaDeUsuarios(){
        int id = 1;
        int per_page = 1;
        int page = 1;
        getListUsersRequest.buscaListaDeUsers()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("size()",greaterThan(0))
                .body("page",equalTo(page))
                .body("per_page",equalTo(per_page))
                .body("data[0].id",equalTo(id))
                .body("data[0].email",equalTo("george.bluth@reqres.in"))
                .body("data[0].first_name",equalTo("George"))
                .body("data[0].last_name",equalTo("Bluth"))
                .body("data[0].avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"));

    }
}
