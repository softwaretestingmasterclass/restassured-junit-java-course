package com.hotelreservation.section4.lecture22.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests extends BaseTest7 {

    @Test
    public void getAllBookingTest() {
        given(spec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void getBookings_with_firstname_filter_test() {
        int bookingId = createBookingId();

        spec.queryParam("firstname", "Ozan");
        Response response = given(spec)
                .when()
                .get("/booking");

        response
                .then()
                .statusCode(200);

        List<Integer> list = response.jsonPath().getList("bookingid");
        Assertions.assertTrue(list.contains(bookingId));

    }


}
