package br.com.restassuredapitest.testes.users.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONException;


import static io.restassured.RestAssured.given;

public class GetSingleUserRequest {

    @Step("Retorna usuário com determinado ID.")
    public Response userById(int id) throws JSONException {

        return given()
                .header("Accept","application/json")
                .when()
                .get("/api/users/" + id);
    }

}
