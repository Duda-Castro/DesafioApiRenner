package br.com.restassuredapitest.testes.users.testes;

import br.com.restassuredapitest.base.BaseTest;
import br.com.restassuredapitest.suites.AllTests;
import br.com.restassuredapitest.testes.users.requests.PatchUserRequest;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

@Feature("Feature de atualização de user.")
public class PatchUserTest extends BaseTest {

    PatchUserRequest patchUserRequest = new PatchUserRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class})
    @DisplayName("Fazer atualização do usuário.")
    public void validarAtualizacaoParcialDoUsuario(){
        String name = new Faker().elderScrolls().firstName();
        String job = new Faker().elderScrolls().creature();
        patchUserRequest.userAlterInfo(name, job)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("size()",greaterThan(0))
                .body("name",equalTo(name))
                .body("job",equalTo(job))
                .body("updatedAt",notNullValue());

    }


}
