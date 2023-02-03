package com.hotelreservation.section3.lecture12;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingIdsTests {

    @Test
    public void getBookingIdsTest() {
        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/2152");

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        String firstname = response.jsonPath().getJsonObject("firstname").toString();
        String lastname = response.jsonPath().getJsonObject("lastname").toString();
        int totalprice = response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("Josh",firstname);
        Assertions.assertEquals("Allen", lastname);
        Assertions.assertEquals(111, totalprice );


    }

}
