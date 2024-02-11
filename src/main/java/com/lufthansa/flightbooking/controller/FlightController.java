package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Api(value = "Flight Booking API", tags = {"Flight Operations"})
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    @ApiOperation(value = "Search Flights", notes = "Search for available flights based on specified criteria")
    public ResponseEntity<List<SearchFlightResponse>> searchFlights(
            @RequestParam("departureId") Long departureAirportId,
            @RequestParam("arrivalId") Long arrivalAirportId,
            @RequestParam("departureDate") String departureDate
            // Additional parameters for search criteria
    ) {
        // Call the flight service to perform the search
        List<SearchFlightResponse> foundFlights = flightService.searchFlights(departureAirportId, arrivalAirportId, departureDate);

        // Return the results as a ResponseEntity
        return new ResponseEntity<>(foundFlights, HttpStatus.OK);
    }
}
