package com.sparta.user.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

import static io.restassured.RestAssured.when;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class deleteUserStepDef {

    String newUser = "{\n" +
            "  \"username\": \"mor94n\",\n" +
            "  \"firstName\": \"Morgan\",\n" +
            "  \"lastName\": \"Ollerton\",\n" +
            "  \"password\": \"mdog420\",\n" +
            "  \"phone\": \"555-2345\",\n" +
            "  \"userStatus\": 1\n" +
            "}";
    @Given("I am a registered user")
    public void i_am_a_registered_user() {
        given().baseUri("https://petstore3.swagger.io")
                .basePath("/api/v3/user")
                .body(newUser, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post();
    }
    @When("I delete my account")
    public void iSendADeleteRequestTo(String arg0) {
        when().delete("https://petstore3.swagger.io/api/v3/user/mor94n");
    }

    @Then("Status code will be 200")
    public void status_code_equals() {
        then().statusCode(200);
    }
}
