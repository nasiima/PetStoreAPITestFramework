package com.sparta.pet.abn;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OrderTests {
    @Test
    @DisplayName("Status code is 200 when ID is valid")
    public void TestStatusCode(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/3")
                .then().assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Test GET response by ID")
    public void TestGetResponseByID(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/2")
                .then().log().all();
    }

    @Test
    @DisplayName("Test GET response body by ID")
    public void TestGetResponseBodyById(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/2")
                .then().log().body();
    }

    @Test
    @DisplayName("Test that order ID is 3")
    public void TestIDis3(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/3")
                .then().body(" id", Matchers.equalTo(3));
    }

    @Test
    @DisplayName("Status code is 404 when ID is invalid")
    public void TestStatusCodeInvalid(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/6")
                .then().assertThat().statusCode(404);
    }

    @ParameterizedTest
    @DisplayName("Test header values when deleting order")
    @CsvSource( {
            "Content-Length, 15",
            "Connection, keep-alive",
            "Access-Control-Allow-Origin, *",
//            "Access-Control-Allow-Methods, GET, POST, DELETE, PUT",
//            "Access-Control-Allow-Headers, Content-Type, api_key, Authorization ",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)"
    })
    public void headerValuesTest(String key, String value){
        RestAssured.get("https://petstore3.swagger.io/api/v3/store/order/2")
                .then().header(key, value);
    }
}
