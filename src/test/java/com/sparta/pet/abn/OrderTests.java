package com.sparta.pet.abn;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTests {
    @Test
    @DisplayName("Status code is 200 when ID is valid")
    public void TestStatusCode(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/2")
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
    @DisplayName("Test that order ID is 2")
    public void TestIDis2(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/2")
                .then().body(" id", Matchers.equalTo(2));
    }

    @Test
    @DisplayName("Status code is 404 when ID is invalid")
    public void TestStatusCodeInvalid(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/store/order/6")
                .then().assertThat().statusCode(404);
    }
}
