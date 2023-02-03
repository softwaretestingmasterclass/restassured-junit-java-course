package com.hotelreservation.section3.lecture14;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests extends BaseTest1 {

    @Test
    public void createBookingTests() {
        Response response = createBooking("Ozan", "Ilhan", 150);

        Assertions.assertEquals("Ozan", response.jsonPath().getJsonObject("booking.firstname").toString());
        Assertions.assertEquals("Ilhan", response.jsonPath().getJsonObject("booking.lastname").toString());

    }
}
