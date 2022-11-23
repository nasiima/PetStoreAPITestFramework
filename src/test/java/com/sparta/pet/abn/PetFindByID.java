package com.sparta.pet.abn;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

public class PetFindByID {

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
    @DisplayName("Status code is 200")
    public void TestStatusCode(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Test GET response by ID")
    public void TestGetResponseByID(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().log().all();
    }

    @Test
    @DisplayName("Test GET response body by ID")
    public void TestGetResponseBodyByIdD(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().log().body();
    }

    @Test
    @DisplayName("Test that ID is 5")
    public void TestIDis5(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().body(" id", Matchers.equalTo(5));
    }

    @Test
    @DisplayName("Test that category is returning correct response")
    public void TestCategoryStringByID(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().body("category", Matchers.equalTo("{id=1, name=Dogs}"
                ));
    }

    @Test
    @DisplayName("Test Access Methods ")
    public void testAccessMethodsSold() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=sold")
                .then().header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    }

    @Test
    @DisplayName("Test Access Header ")
    public void testAccessHeaderSold() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=sold")
                .then().header("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization");
    }

    @Test
    @DisplayName("Test that Status is Sold")
    public void TestStatusIsSold(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().body("status", Matchers.equalTo("sold"
                ));
    }

    @Test
    @DisplayName("Test that name is Dog 2")
    public void TestNameIsDog2(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().body("name", Matchers.equalTo("Dog 2"
                ));
    }


    @ParameterizedTest
    @DisplayName("Test header values")
    @CsvSource( {
            "Content-Type, application/json",
            "Content-Length, 156",
            "Connection, keep-alive",
            "Access-Control-Allow-Origin, *",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)",


    })
    public void headerValuesTest(String key, String value){
        RestAssured.get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().header(key, value);
    }



    @Test
    @DisplayName("Test POST new pet by ID")
    public void TestPostByID(){
        given().baseUri("https://petstore3.swagger.io")
                .basePath("/api/v3/pet/20?name=nasiima&status=available")
                .body(newPet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post();
    }



    @Test
    @DisplayName("Test DELETE by ID status is 404")
    public void TestDeleteByID(){

        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/6")
                .then().assertThat().statusCode(404);
    }
}