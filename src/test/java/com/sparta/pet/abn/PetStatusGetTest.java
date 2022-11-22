package com.sparta.pet.abn;

import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class PetStatusGetTest {
    static Response response;

    @BeforeAll
    public static void setUp() {
        response = RestAssured.get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available");
    }

    @Test
    @DisplayName("Status Code is correct")
    public void testStatusCode() {
        response.then()
                .assertThat().statusCode(200);
    }


    @ParameterizedTest
    @DisplayName("Test header values")
    @CsvSource({
            "Content-Type, application/json",
//            "Content-Length, 2637", always changing so not reliable
            "Connection, keep-alive",
            "Access-Control-Allow-Origin, *",
//            "Access-Control-Allow-Methods, GET,POST,DELETE,PUT",
//            "Access-Control-Allow-Headers, Content-Type,api_key,Authorization ",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)",

    })
    public void headerValuesTest(String key, String value) {
        response.then().header(key, value);
    }

    @Test
    @DisplayName("Test Access Methods ")
    public void testAccessMethods() {
        response.then().header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    }

    @Test
    @DisplayName("Test Access Header ")
    public void testAccessHeader() {
        response.then().header("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization");
    }

}

