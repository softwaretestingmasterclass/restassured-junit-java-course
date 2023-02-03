package com.hotelreservation.section4.lecture20;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateBookingTests extends BaseTest6 {

    @Test
    public void createBookingTest() {
        Response response = createBooking();

        Assertions.assertEquals("Ozan", response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Ilhan", response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(200, (Integer) response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true, response.jsonPath().getJsonObject("booking.depositpaid"));

    }
}
