package com.sparta.store.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.rest.SerenityRest.*;

public class orderStepDefs {

    @Given("I want to send {string} as request body")
    public void iWantToSendAsRequestBody(String requestBody) {
        given().body(requestBody)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
    }

    @When("I send post request to {string}")
    public void iSendPostRequestTo(String URL) {
        when().post(URL);
    }

    @When("I send get request to {string}")
    public void iSendGetRequestTo(String URL) {
        when().get(URL);
    }

    @Then("I get response code {int}")
    public void iGetResponseCode(int code) {
        then().statusCode(code);
    }

    @And("I get an error message {string}")
    public void iGetAnErrorMessage(String message) {
        then().body("message", containsString(message));
    }


    @And("I get a map of status codes to quantities")
    public void iGetAMapOfStatusCodesToQuantities() {
        then().body("approved", equalTo(50))
                .body("placed", equalTo(100))
                .body("delivered", equalTo(50));
    }

    @And("I get response object with values {int} {int} {int} {string}")
    public void iGetResponseObjectWithValuesTrue(int id, int petId, int quantity, String complete) {
        then().body("id", equalTo(id))
                .body("petId", equalTo(petId))
                .body("quantity", equalTo(quantity))
                .body("complete", equalTo(Boolean.valueOf(complete)));
    }
}