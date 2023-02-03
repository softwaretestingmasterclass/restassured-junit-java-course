package com.hotelreservation.section3.lecture16;

import com.hotelreservation.section3.lecture15.BaseTest2;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartiallyUpdateBookingTests extends BaseTest3 {

    @Test
    public void partiallyUpdateBooking() {
        String token = createToken();
        int bookingId = createBookingId("Ozan", "Ilhan", 10);

        JSONObject body = new JSONObject();
        body.put("firstname", "Ayse");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(body.toString())
                .patch("https://restful-booker.herokuapp.com/booking/" + bookingId);

        response.prettyPrint();

        Assertions.assertEquals("Ayse", response.jsonPath().getJsonObject("firstname"));
    }
}
