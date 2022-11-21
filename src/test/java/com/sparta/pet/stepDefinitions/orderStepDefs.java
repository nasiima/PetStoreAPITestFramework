package com.sparta.pet.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class orderStepDefs {
    static Response response;

    @When("I send post request to {string}")
    public void iSendPostRequestTo(String URL) {
        response = RestAssured.post(URL);
    }

    @And("I send Order object as request body")
    public void iSendOrderObjectAsRequestBody() {
    }

    @Then("I get response code {int}")
    public void iGetResponseCode(int code) {
    }

    @And("I get Order object as response body")
    public void iGetOrderObjectAsResponseBody() {
    }

    @And("I send empty request body")
    public void iSendEmptyRequestBody() {
    }

    @And("I get an error message {string}")
    public void iGetAnErrorMessage(String message) {
    }

    @And("I send empty Order object as a request body")
    public void iSendEmptyOrderObjectAsARequestBody() {
    }

    @And("I get Order object with default values")
    public void iGetOrderObjectWithDefaultValues() {
    }
}
