package com.sparta.pet.abn;

import com.sparta.pet.dto.PetResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PetUrlTest {

   String newPet = "{\n" +
           "  \"id\": 0,\n" +
           "  \"category\": {\n" +
           "    \"id\": 0,\n" +
           "    \"name\": \"string\"\n" +
           "  },\n" +
           "  \"name\": \"doggie\",\n" +
           "  \"photoUrls\": [\n" +
           "    \"string\"\n" +
           "  ],\n" +
           "  \"tags\": [\n" +
           "    {\n" +
           "      \"id\": 0,\n" +
           "      \"name\": \"string\"\n" +
           "    }\n" +
           "  ],\n" +
           "  \"status\": \"available\"\n" +
           "}";

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
        given().baseUri("https://petstore3.swagger.io")
                .basePath("/#/pet/addPet")
                .body(newPet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post();
    }
}
