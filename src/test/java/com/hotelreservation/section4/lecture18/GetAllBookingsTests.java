package com.hotelreservation.section4.lecture18;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests extends BaseTest5 {

    @Test
    public void getAllBookingTest() {
        given(spec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);

    }


}
