package com.lufthansa.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(Long departureAirportId, Long arrivalAirportId, String departureDate, long noOfTraveller) {
        super(String.format("No flights found for the given criteria: Departure Airport ID %d, Arrival Airport ID %d, Departure Date %s, No. of Travellers %d",
                departureAirportId, arrivalAirportId, departureDate, noOfTraveller));
    }

}