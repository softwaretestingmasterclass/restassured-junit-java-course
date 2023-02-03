package com.hotelreservation.section4.lecture23.tests;

import com.hotelreservation.section4.lecture23.models.Booking;
import com.hotelreservation.section4.lecture23.models.BookingDates;
import com.hotelreservation.section4.lecture23.models.BookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests extends BaseTest8 {

    @Test
    public void createBookingTest() {
        Response response = createBooking();

        Assertions.assertEquals("Ozan", response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Ilhan", response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(200, (Integer) response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true, response.jsonPath().getJsonObject("booking.depositpaid"));

    }

    @Test
    public void createBookingWithPojo() {
        BookingDates bookingDates = new BookingDates("2023-01-01", "2023-01-02");
        Booking booking = new Booking("Udemy", "Kurs", 350, true, bookingDates, "Tek kisilik yatak");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(booking)
                .post("/booking");

        response
                .then()
                .statusCode(200);

        BookingResponse bookingResponse = response.as(BookingResponse.class);

        Assertions.assertEquals("Udemy", bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Kurs", bookingResponse.getBooking().getLastname());
        Assertions.assertEquals("Tek kisilik yatak", bookingResponse.getBooking().getAdditionalneeds());
    }
}
