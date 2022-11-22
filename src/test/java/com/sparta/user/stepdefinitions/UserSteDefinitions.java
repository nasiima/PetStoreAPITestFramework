package com.sparta.user.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteDefinitions {
    @Given("I am a logged in user")
    public void iAmALoggedInUser() {
    }

    @When("I send a get request to {string}")
    public void iSendAGetRequestTo(String arg0) {
    }

    @Then("I should receive the message {string}")
    public void iShouldReceiveTheMessage(String arg0) {
    }

    @When("I send a post request to {string}")
    public void iSendAPostRequestTo(String arg0) {
    }

    @And("I make changes to the body")
    public void iMakeChangesToTheBody() {
    }

    @Then("I should get the response code {int}")
    public void iShouldGetTheResponseCode(int arg0) {
    }

    @When("I update my account details")
    public void iUpdateMyAccountDetails() {
    }

    @Then("I should see my updated account details")
    public void iShouldSeeMyUpdatedAccountDetails() {
    }
}
