package com.sparta.pet.stepDefinitions;

import com.sparta.pet.dto.PetResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static net.serenitybdd.rest.SerenityRest.then;

public class PetStepDefs {
//    String newPet = "{\n" +
//                "  \"id\": 0,\n" +
//            "  \"category\": {\n" +
//            "    \"id\": 0,\n" +
//            "    \"name\": \"string\"\n" +
//            "  },\n" +
//            "  \"name\": \"doggie\",\n" +
//            "  \"photoUrls\": [\n" +
//            "    \"string\"\n" +
//            "  ],\n" +
//            "  \"tags\": [\n" +
//            "    {\n" +
//            "      \"id\": 0,\n" +
//            "      \"name\": \"string\"\n" +
//            "    }\n" +
//            "  ],\n" +
//            "  \"status\": \"available\"\n" +
//            "}";

    @Given("I added a new Pet")
    public int iAddedANewPet() {
        PetResponse response = new PetResponse("doggie", 0, "available");

        int newID = given().baseUri("https://petstore3.swagger.io")
                .basePath("/#/pet/addPet")
                .body(response, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(PetResponse.class, ObjectMapperType.GSON).getId();
        return newID;
    }

    @When("I search for Pets id")
    public void iSearchForPetsId(int id) {
        when().get("/" + id);
    }

    @Then("The response contains pets id")
    public void theResponseContainsPetsId() {
        then().body("name", Matchers.equalTo("doggie"));
    }
}
