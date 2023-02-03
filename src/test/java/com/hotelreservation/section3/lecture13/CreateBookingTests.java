package com.hotelreservation.section3.lecture13;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests {

    @Test
    public void createBookingTests() {
        JSONObject body = new JSONObject();
        body.put("firstname", "Ozan");
        body.put("lastname", "Ilhan");
        body.put("totalprice", 150);
        body.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2023-01-01");
        bookingDates.put("checkout", "2023-01-02");

        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Kopek Yatagi");

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

        Assertions.assertEquals("Ozan", response.jsonPath().getJsonObject("booking.firstname").toString());
        Assertions.assertEquals("Ilhan", response.jsonPath().getJsonObject("booking.lastname").toString());

    }
}
