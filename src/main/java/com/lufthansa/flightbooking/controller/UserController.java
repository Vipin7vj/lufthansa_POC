package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.repository.BookingRepository;
import com.lufthansa.flightbooking.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@Api(value = "User API", tags = {"User Operations"})
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get Bookings by User ID", notes = "Retrieve bookings associated with the specified user ID")
    public ResponseEntity<List<BookingResponse>> getBookingsByUserId(@PathVariable Long userId) {
        logger.info("Received request to get bookings for user with ID: {}", userId);

         List<BookingResponse> bookings = userService.getBookingsByUserId(userId);

        if (bookings.isEmpty()) {
            logger.warn("No bookings found for user with ID: {}", userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            logger.info("Returning {} bookings for user with ID: {}", bookings.size(), userId);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }
}
