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

public class PostStoreOrderTests extends UIInteractions {
    @Test
    @DisplayName("Successful order post request")
    public void testOrderPostRequest() {
        Order order = new Order(10, 198772, 7, LocalDateTime.now().plusDays(1), "approved", true);

        Order responseOrder = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/api/v3/store/order")
                .body(order, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post()
                .getBody()
                .as(Order.class, ObjectMapperType.GSON);

        MatcherAssert.assertThat(responseOrder.getId(), equalTo(10));
    }
}