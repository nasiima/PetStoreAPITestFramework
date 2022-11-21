package com.sparta.pet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PetTest {

    @Test
    @DisplayName("Status code is correct")
    public void TestStatusCode(){
//        RestAssured
//                .when()
//                .get("https://www.boredapi.com/api/activity")
        response.then().assertThat().statusCode(200);
    }
}
