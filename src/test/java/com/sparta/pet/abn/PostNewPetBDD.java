package com.sparta.pet.abn;

import com.sparta.pet.dto.Category;
import com.sparta.pet.dto.PetResponse;
import com.sparta.pet.dto.TagsItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import org.checkerframework.checker.guieffect.qual.UI;
import org.hamcrest.Matchers;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static net.serenitybdd.rest.SerenityRest.then;

public class PostNewPetBDD {

    String newPet = "{\n" +
            "  \"id\": 0,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    @Given("I am on the addPet Page and I added a new Pet")
    public void iAmOnTheAddPetPageAndIAddedANewPet() {
        given().baseUri("https://petstore3.swagger.io")
                .basePath("/#/pet/addPet")
                .body(newPet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post();
    }

    @When("I search for Pets id")
    public void iSearchForPetsId(int id) {
        when().get("/" + id);
    }

    @Then("The response contains pets id")
    public void theResponseContainsPetsId() {
        then().body("id", Matchers.equalTo(0));
    }
}
