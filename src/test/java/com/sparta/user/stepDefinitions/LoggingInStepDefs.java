package com.sparta.user.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.MatcherAssert.assertThat;



public class LoggingInStepDefs {

    String newUser = "{\n" +
            "  \"username\": \"poppybeans\",\n" +
            "  \"firstName\": \"Poppy\",\n" +
            "  \"lastName\": \"Beans\",\n" +
            "  \"password\": \"paws\",\n" +
            "  \"phone\": \"555-1234\",\n" +
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

    @When("I log in")
    public void i_log_in() {
        when().get("https://petstore3.swagger.io/api/v3/user/logout");
        when().get("https://petstore3.swagger.io/api/v3/user/login?username=poppybeans&password=paws").toString();

    }

    @Then("The response contains {string}")
    public void the_response_contains(String string) {
        then().body(Matchers.contains(string));
    }

    @Given("I am logged in")
    public void i_am_logged_in() {
        given().get("https://petstore3.swagger.io/api/v3/user/login?username=poppybeans&password=paws");
    }

    @When("I view my account details")
    public void i_view_my_account_details() {
        when().get("https://petstore3.swagger.io/api/v3/user/poppybeans");
    }

    @Then("The details contain the correct information")
    public void the_details_contain_the_correct_information() {
        then().body("password", Matchers.equalTo("paws"));
    }
}
