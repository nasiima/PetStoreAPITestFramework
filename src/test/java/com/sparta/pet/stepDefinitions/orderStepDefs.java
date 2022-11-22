package com.sparta.pet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.rest.SerenityRest.*;

public class orderStepDefs {
    static Response response;

    @Given("I send requests to API {string}")
    public void iSendRequestsToAPI(String URL) {
    }

    @When("I send post request to {string}")
    public void iSendPostRequestTo(String URL) {
        response = RestAssured.post(URL);
    }

    @And("I send Order object as request body")
    public void iSendOrderObjectAsRequestBody() {
    }

    @When("I send get request to {string}")
    public void iSendGetRequestTo(String URL) {
        when().get(URL);
    }

    @Then("I get response code {int}")
    public void iGetResponseCode(int code) {
        then().statusCode(code);
    }

    @And("I get Order object as response body")
    public void iGetOrderObjectAsResponseBody() {
    }

    @And("I send empty request body")
    public void iSendEmptyRequestBody() {
    }

    @And("I get an error message {string}")
    public void iGetAnErrorMessage(String message) {
        then().body("message", equalTo(message));
    }

    @And("I send empty Order object as a request body")
    public void iSendEmptyOrderObjectAsARequestBody() {
    }

    @And("I get Order object with default values")
    public void iGetOrderObjectWithDefaultValues() {
    }

    @And("I get a map of status codes to quantities")
    public void iGetAMapOfStatusCodesToQuantities() {
        then().body("approved", equalTo(12))
                .body("placed", equalTo(107))
                .body("delivered", equalTo(50));
    }


}
