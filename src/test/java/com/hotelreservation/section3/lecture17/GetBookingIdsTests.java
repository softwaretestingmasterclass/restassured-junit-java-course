package com.hotelreservation.section3.lecture17;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingIdsTests extends BaseTest4 {

    @Test
    public void getBookingIdsTest() {
        Response booking = createBooking("Ozan", "Ilhan", 150);
        int bookingId = booking.jsonPath().getJsonObject("bookingid");


        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/" + bookingId);

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        String firstname = response.jsonPath().getJsonObject("firstname").toString();
        String lastname = response.jsonPath().getJsonObject("lastname").toString();
        int totalprice = response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("Ozan", firstname);
        Assertions.assertEquals("Ilhan", lastname);
        Assertions.assertEquals(150, totalprice);


    }

}
