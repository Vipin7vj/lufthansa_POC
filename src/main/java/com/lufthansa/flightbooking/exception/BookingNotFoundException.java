package com.lufthansa.flightbooking.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Long userId) {
        super("Bookings not found for user with ID: " + userId);
    }
}

