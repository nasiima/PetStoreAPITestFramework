package com.sparta.pet.abn;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PetFindByID {
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
                .then().body("category", Matchers.equalTo(" {id=1, name=Dogs}"
               ));
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
            "Access-Control-Allow-Methods, GET, POST, DELETE, PUT",
            "Access-Control-Allow-Headers, Content-Type, api_key, Authorization ",
            "Access-Control-Expose-Headers, Content-Disposition",
            "Server, Jetty(9.4.9.v20180320)",


    })
    public void headerValuesTest(String key, String value){
        RestAssured.get("https://petstore3.swagger.io/api/v3/pet/5")
                .then().header(key, value);
    }



//
//
//    @Test
//    @DisplayName("Test POST by ID")
//    public void TestPostByID(){
//        RestAssured
//                .when()
//                .get("https://petstore3.swagger.io/api/v3/pet/5")
//                .then().log().all();
//    }




//    @Test
//    @DisplayName("Test DELETE by ID")
//    public void TestDeleteByID(){
//        RestAssured
//                .when()
//                .get("https://petstore3.swagger.io/api/v3/pet/5")
//                .then().body().all().delete().assertThat().statusCode(204);
//    }
}
