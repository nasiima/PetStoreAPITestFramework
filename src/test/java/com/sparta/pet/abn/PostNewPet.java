//package com.sparta.pet.abn;
//
//import com.sparta.pet.dto.Category;
//import com.sparta.pet.dto.PetResponse;
//import com.sparta.pet.dto.TagsItem;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.mapper.ObjectMapperType;
//import net.serenitybdd.core.steps.UIInteractions;
//import org.checkerframework.checker.guieffect.qual.UI;
//import org.hamcrest.Matchers;
//
//import java.util.Collections;
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;
//import static net.serenitybdd.rest.SerenityRest.then;
//
//public class PostNewPet extends UIInteractions {
////    @Given("I am on the addPet Page")
////    public void iAmOnTheAddPetPage() {
////        RestAssured.baseURI = "https://petstore3.swagger.io/#/pet/addPet";
////        Category category = new Category();
////        TagsItem tagsItem = new TagsItem();
////        PetResponse pet = new PetResponse(Collections.singletonList("strings"), "doggie", 10, category, (List<TagsItem>) tagsItem, "available" );
////
////        given()
////                .baseUri("https://petstore3.swagger.io/#/pet/addPet")
////                .body(pet, ObjectMapperType.GSON)
////                .accept(ContentType.JSON)
////                .contentType(ContentType.JSON).post().getBody().as(PetResponse.class, ObjectMapperType.GSON).getId();
////    }
////
////    @When("I click on Execute button")
////    public void iClickOnExecuteButton(Long id) {
////        when().get("/" + id);
////    }
////
////    @Then("I add a new pet to the store")
////    public void iAddANewPetToTheStore() {
////        then().body("name", Matchers.equalTo("doggie"));
////
//
//    }
//}
