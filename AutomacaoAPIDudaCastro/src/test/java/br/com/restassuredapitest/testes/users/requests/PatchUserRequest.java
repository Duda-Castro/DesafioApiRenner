package br.com.restassuredapitest.testes.users.requests;

import br.com.restassuredapitest.testes.users.requests.payloads.UsersPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PatchUserRequest {
    UsersPayloads usersPayloads = new UsersPayloads();
    @Step("Alterar um usuário.")
    public Response userAlterInfo(String nome,String job){
        int id = 1;
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .queryParam("id",id)
                .when()
                .body(usersPayloads.payloadPatch(nome,job).toString())
                .patch("/api/users/" + id);
    }
}
