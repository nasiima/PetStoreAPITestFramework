package com.sparta.pet.abn;

import com.sparta.pet.dto.Order;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.rest.SerenityRest.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PostStoreOrderTests extends UIInteractions {
    @Test
    @DisplayName("Successful order post request")
    public void testOrderPostRequest() {
        Order order = new Order(10, 198772, 7, new Date(), "approved", true);

        var v1 = given();
        var v2 = v1.body("{\n" +
                "  \"id\": 10,\n" +
                "  \"petId\": 198772,\n" +
                "  \"quantity\": 7,\n" +
                "  \"shipDate\": \"2022-11-22T13:55:10.012Z\",\n" +
                "  \"status\": \"approved\",\n" +
                "  \"complete\": true\n" +
                "}");
        var v3 = v2.accept(ContentType.JSON);
        var v4 = v3.contentType(ContentType.JSON);
        var v5 = v4.post("https://petstore3.swagger.io/api/v3/store/order");
        v5.then().statusCode(200);
    }
}