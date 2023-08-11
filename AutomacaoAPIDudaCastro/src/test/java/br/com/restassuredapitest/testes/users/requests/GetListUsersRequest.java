package br.com.restassuredapitest.testes.users.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetListUsersRequest {
    @Step("Busca lista de usuários.")
    public Response buscaListaDeUsers (){

        return given()
                .header("Accept","application/json")
                .when()
                .get("/api/users?page=1&per_page=1");
        }
    }

