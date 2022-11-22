package com.sparta.user.stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;

import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;


public class UserStepDefinitions {


    String newUser = "{\n" +
            "  \"username\": \"cheesus\",\n" +
            "  \"firstName\": \"Rumana\",\n" +
            "  \"lastName\": \"hellooo\",\n" +
            "  \"password\": \"cheese\",\n" +
            "  \"phone\": \"cheese\",\n" +
            "  \"userStatus\": 1\n" +
            "}";

    String changeUser = "{\n" +
            "  \"username\": \"cheesus\",\n" +
            "  \"firstName\": \"Rumana\",\n" +
            "  \"lastName\": \"lopes\",\n" +
            "  \"password\": \"cheese\",\n" +
            "  \"phone\": \"cheese\",\n" +
            "  \"userStatus\": 1\n" +
            "}";

    private String response;

    @Given("I am a logged in user")
    public void iAmALoggedInUser() {
        given().get("https://petstore3.swagger.io/api/v3/user/login?username=cheesus&password=cheese");
    }

    @When("I send a get request to {string}")
    public void iSendAGetRequestTo(String string) {
        when().get("string");
    }

    @Then("I should receive the message {string}")
    public void iShouldReceiveTheMessage(String string) {
        then().body(Matchers.contains(string));
    }

    @When("I send a put request to {string}")
    public void iSendAPutRequestTo(String arg0) {
//        response = when().baseUri("https://petstore3.swagger.io")
//                .basePath("/api/v3/user")
//                .body(changeUser, ObjectMapperType.GSON)
//                .accept(ContentType.JSON)
//                .contentType(ContentType.JSON).put("/cheesus");
    }


    @Then("I should get the response code {int}")
    public void iShouldGetTheResponseCode(int code) {
        RestAssured
                .when()
                .get("https://petstore3.swagger.io/api/v3/user/cheesus")
                .then().assertThat().statusCode(code);
    }

    @Then("I should see my updated account details")
    public void iShouldSeeMyUpdatedAccountDetails() {
        then().body("lastname", Matchers.equalTo("lopes"));
    }
}
