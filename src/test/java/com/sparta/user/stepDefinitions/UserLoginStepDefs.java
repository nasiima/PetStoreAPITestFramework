package com.sparta.user.stepDefinitions;

import com.sparta.user.dto.UserDetailsResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;

import static net.serenitybdd.rest.SerenityRest.*;
import static net.serenitybdd.rest.SerenityRest.then;

public class UserLoginStepDefs {

    Response response;
    UserDetailsResponse udResponse;
    private static JSONObject jsonObject = null;




    String newUser = """
                {
                  "username": "poppybeans",
                  "firstName": "Poppy",
                  "lastName": "Beans",
                  "password": "paws",
                  "phone": "555-1234",
                  "userStatus": 1
                }""";


    @Given("I am an already registered user")
    public void iAmAnAlreadyRegisteredUser() {
        given().baseUri("https://petstore3.swagger.io")
                    .basePath("/api/v3/user")
                    .body(newUser, ObjectMapperType.GSON)
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON).post();
    }


    @When("I log in")
    public void i_log_in() {
        when().get("https://petstore3.swagger.io/api/v3/user/login?username=poppybeans&password=paws");

    }

    @Then("The response contains {string}")
    public void the_response_contains(String string) {
        then().body(Matchers.contains(string));
    }



    @When("I view my account details")
    public void i_view_my_account_details(){
        when().get("https://petstore3.swagger.io/api/v3/user/poppybeans");
    }

    @Then("The details contain the correct information")
    public void the_details_contain_the_correct_information() {
        then().body("lastname", Matchers.equalTo("Beans"));
    }

    @AfterEach
    public void tearDown() {
        SerenityRest.delete("https://petstore3.swagger.io/api/v3/user/poppybeans");
    }


    @Given("I am an unregistered user")
    public void iAmAnUnregisteredUser() {
        given().delete("https://petstore3.swagger.io/api/v3/user/notarealusername");
    }

    @When("I try to log in")
    public void iTryToLogIn() {
            when().get("https://petstore3.swagger.io/api/v3/user/" +
                    "login?username=notarealusername&password=notarealpassword");
    }

    @Then("The status code is {int}")
    public void theStatusCodeIs(int statusCode) {
            then().statusCode(Matchers.equalTo(statusCode));
    }
}
