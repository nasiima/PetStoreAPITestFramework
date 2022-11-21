package com.sparta.pet.abn;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PetStatusGetTest {

    @Test
    @DisplayName("Status code is 200")
    public void TestStatusCode(){
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .then().assertThat().statusCode(200);
    }
}
