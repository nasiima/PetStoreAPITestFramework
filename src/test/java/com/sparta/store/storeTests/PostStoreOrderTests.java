package com.sparta.store.storeTests;

import net.serenitybdd.core.steps.UIInteractions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import static net.serenitybdd.rest.SerenityRest.*;

public class PostStoreOrderTests extends UIInteractions {
    @Test
    @DisplayName("Successful order post request")
    public void testOrderPostRequest() {
        given().body("{ \"id\": 10, \"petId\": 198772, \"quantity\": 7, \"shipDate\": \"2022-11-22T13:55:10.012Z\", \"status\": \"approved\", \"complete\": true }")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        when().post("https://petstore3.swagger.io/api/v3/store/order");
        then().statusCode(200);
    }

    @Test
    @DisplayName("Order post request without body")
    public void testOrderPostRequestWithoutBody() {
        given().body("")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        when().post("https://petstore3.swagger.io/api/v3/store/order");
        then().statusCode(500)
                .body("message", containsString("There was an error processing your request"));
    }

    @Test
    @DisplayName("Order post request without body")
    public void testOrderPostRequestWithEmptyJsonObject() {
        given().body("{}")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        when().post("https://petstore3.swagger.io/api/v3/store/order");
        then().statusCode(200)
                .body("id", equalTo(0))
                .body("petId", equalTo(0))
                .body("quantity", equalTo(0))
                .body("complete", equalTo(false));
    }

    @Test
    @DisplayName("Order post request with a misprint in the URL")
    public void testOrderPostRequestWithMisprint() {
        given().body("{ \"id\": 10, \"petId\": 198772, \"quantity\": 7, \"shipDate\": \"2022-11-22T13:55:10.012Z\", \"status\": \"approved\", \"complete\": true }")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        when().post("https://petstore3.swagger.io/api/v3/store/oder");
        then().statusCode(404)
                .body("message", equalTo("HTTP 404 Not Found"));
    }
}