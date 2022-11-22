package com.sparta.user.UserTests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import io.restassured.RestAssured;

@ExtendWith(SerenityJUnit5Extension.class)
public class DeleteUserTest {

    @Test
    @DisplayName("When a logged in user deletes account, status code will be 200")
    public void deleteUserTest() {
        RestAssured
                .when().delete("https://petstore3.swagger.io/api/v3/user/mor94n")
                .then().statusCode(200);
    }
}
