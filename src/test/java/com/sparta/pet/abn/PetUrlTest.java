package com.sparta.pet.abn;

import com.sparta.pet.dto.PetResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PetUrlTest {

    @Test
    @DisplayName("Status code is correct")
    public void TestStatusCode() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/#/pet/addPet").then().assertThat().statusCode(200);
    }

    @Test
    @DisplayName("POST new pet")
            public void testPostNewPet() {

        RestAssured.baseURI = "https://petstore3.swagger.io/#/pet/addPet";
        given()
                .param("id", "10")
                .param("name", "doggie")
                .post("/addPet")
                .then().statusCode(200);

    }
}
