package com.hotelreservation.section3.lecture16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTest3 {

    @Test
    public void updateBookingTests() {
        String token = createToken();
        int bookingId = createBookingId("Ozan", "Ilhan", 150);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(bookingObject("Suzy", "Ahmet", 1500)).log().all()
                .put("https://restful-booker.herokuapp.com/booking/" + bookingId);

        response.prettyPrint();
        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastName = response.jsonPath().getJsonObject("lastname");
        int totalPrice = response.jsonPath().getJsonObject("totalprice");


        Assertions.assertEquals("Suzy", firstName, "Matcher is not correct");
        Assertions.assertEquals("Ahmet", lastName, "Matcher is not correct");
        Assertions.assertEquals(1500, totalPrice, "Matcher is not correct");

    }

}
