package com.hotelreservation.section3.lecture17;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTests extends BaseTest4 {

    @Test
    public void deleteBookingTest() {
        String token = createToken();
        int bookingId = createBookingId("Ozan", "Ilhan", 5);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .delete("https://restful-booker.herokuapp.com/booking/" + bookingId);

        response
                .then()
                .statusCode(201);

        response.prettyPrint();
    }
}
