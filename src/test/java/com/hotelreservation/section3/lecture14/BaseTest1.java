package com.hotelreservation.section3.lecture14;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest1 {

    protected Response createBooking(String firstname, String lastname, int totalAmount) {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(bookingObject(firstname, lastname, totalAmount))
                .post("https://restful-booker.herokuapp.com/booking");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        return response;
    }

    protected String bookingObject(String firstname, String lastname, int totalAmount) {
        JSONObject body = new JSONObject();
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        body.put("totalprice", totalAmount);
        body.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2023-01-01");
        bookingDates.put("checkout", "2023-01-02");

        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Kopek Yatagi");
        return body.toString();
    }

}
