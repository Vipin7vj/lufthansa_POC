package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.BookingRequest;
import com.lufthansa.flightbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping("/save")
    public ResponseEntity<String> saveBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            // Call the booking service to save the booking request
            bookingService.saveBooking(bookingRequest);

            return new ResponseEntity<>("Booking saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save booking: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
