package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.repository.BookingRepository;
import com.lufthansa.flightbooking.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get Bookings by User ID", notes = "Retrieve bookings associated with the specified user ID")
    public ResponseEntity<List<BookingResponse>> getBookingsByUserId(@PathVariable Long userId) {
        List<BookingResponse> bookings = userService.getBookingsByUserId(userId);

        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }
}