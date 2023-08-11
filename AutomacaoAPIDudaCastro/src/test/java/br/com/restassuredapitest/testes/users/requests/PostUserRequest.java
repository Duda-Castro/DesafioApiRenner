package br.com.restassuredapitest.testes.users.requests;

import br.com.restassuredapitest.testes.users.requests.payloads.UsersPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostUserRequest {
    UsersPayloads usersPayloads = new UsersPayloads();
    @Step("Cria um novo user.")
    public Response criaUsuario(String name,String job){

        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .when()
                .body(usersPayloads.payloadValidoCreateUser(name,job).toString())
                .post("/api/users");



    }

}
