package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.BookingCancellationRequest;
import com.lufthansa.flightbooking.dto.BookingRequest;
import com.lufthansa.flightbooking.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class for creating and cancelling the booking.
 */
@RestController
@RequestMapping("v1/booking")
@Api(value = "Booking API", tags = {"Booking Operations"})
@Validated
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;

    /**
     * Endpoint to save a new booking based on the provided request.
     *
     * @param bookingRequest The request containing booking details.
     * @return ResponseEntity with a success message and HTTP status code 201 (Created).
     */
    @PostMapping("/save")
    @ApiOperation(value = "Save Booking", notes = "Create a new booking based on the provided request")
    public ResponseEntity<String> saveBooking(@Valid @RequestBody BookingRequest bookingRequest) {
        logger.info("Received request to save booking: {}", bookingRequest);
        bookingService.saveBooking(bookingRequest);
        logger.info("Booking saved successfully");
        return new ResponseEntity<>("Booking saved successfully", HttpStatus.CREATED);
    }

    /**
     * Endpoint to cancel bookings based on the provided booking IDs.
     *
     * @param request The request containing booking IDs to be canceled.
     * @return ResponseEntity with a success message and HTTP status code 200 (OK).
     */
    @PutMapping("/cancel")
    @ApiOperation(value = "Cancel Bookings", notes = "Cancel bookings based on provided booking IDs")
    public ResponseEntity<String> cancelBookings(@Valid @RequestBody BookingCancellationRequest request) {
        logger.info("Received request to cancel bookings with IDs: {}", request.getBookingIds());
        bookingService.cancelBookings(request);
        logger.info("Bookings canceled successfully");
        return new ResponseEntity<>("Bookings canceled successfully", HttpStatus.OK);
    }

}
