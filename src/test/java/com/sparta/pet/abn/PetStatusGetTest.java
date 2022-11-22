package com.sparta.pet.abn;

import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class PetStatusGetTest {

    // available status
    @Test
    @DisplayName("Status Code is correct")
    public void testStatusCodeAvailable() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .then().assertThat().statusCode(200);
    }

    @ParameterizedTest
    @DisplayName("Test header values")
    @CsvSource({
            "Content-Type, application/json",
            "Connection, keep-alive",
            "Access-Control-Allow-Origin, *",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)",
    })
    public void headerValuesTestAvailable(String key, String value) {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .then().header(key, value);
    }

    @Test
    @DisplayName("Test Access Methods ")
    public void testAccessMethodsAvailable() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .then().header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    }

    @Test
    @DisplayName("Test Access Header ")
    public void testAccessHeaderAvailable() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .then().header("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization");
    }

    @Test
    @DisplayName("Test GET response by status")
    public void TestGetResponseByIDAvailable() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .then().log().all();
    }// tests the body


    //  pending status

    @Test
    @DisplayName("Status Code is correct")
    public void testStatusCodePending() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=pending")
                .then().assertThat().statusCode(200);
    }


    @ParameterizedTest
    @DisplayName("Test header values")
    @CsvSource({
            "Content-Type, application/json",
            "Connection, keep-alive",
            "Access-Control-Allow-Origin, *",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)",
    })
    public void headerValuesTestPending(String key, String value) {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=pending")
                .then().header(key, value);
    }

    @Test
    @DisplayName("Test Access Methods ")
    public void testAccessMethodsPending() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=pending")
                .then().header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    }

    @Test
    @DisplayName("Test Access Header ")
    public void testAccessHeaderPending() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=pending")
                .then().header("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization");
    }

    @Test
    @DisplayName("Test GET response by status")
    public void TestGetResponseByIDPending() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=pending")
                .then().log().all();
    }// tests the body



    //  sold status

    @Test
    @DisplayName("Status Code is correct")
    public void testStatusCodeSold() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=sold")
                .then().assertThat().statusCode(200);
    }


    @ParameterizedTest
    @DisplayName("Test header values")
    @CsvSource({
            "Content-Type, application/json",
            "Connection, keep-alive",
            "Access-Control-Allow-Origin, *",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)",
    })
    public void headerValuesTestSold(String key, String value) {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=sold")
                .then().header(key, value);
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
    @DisplayName("Test GET response by status")
    public void TestGetResponseByIDSold() {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=sold")
                .then().log().all();
    }// tests the body
}

