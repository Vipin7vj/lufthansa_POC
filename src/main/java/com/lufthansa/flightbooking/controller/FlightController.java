package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller class for handling flight-related operations.
 */
@RestController
@RequestMapping("/flights")
@Api(value = "Flight Booking API", tags = {"Flight Operations"})
@Validated
public class FlightController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

    /**
     * Searches for available flights based on specified criteria.
     *
     * @param departureAirportId ID of the departure airport
     * @param arrivalAirportId   ID of the arrival airport
     * @param departureDate      Date of departure in the format yyyy-MM-dd
     * @return ResponseEntity containing a list of SearchFlightResponse
     */
    @GetMapping("/search")
    @ApiOperation(value = "Search Flights", notes = "Search for available flights based on specified criteria")
    public ResponseEntity<List<SearchFlightResponse>> searchFlights(
            @NotNull(message = "Departure ID cannot be null")
            @RequestParam("departureId") Long departureAirportId,

            @NotNull(message = "Arrival ID cannot be null")
            @RequestParam("arrivalId") Long arrivalAirportId,

            @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format. Use yyyy-MM-dd")
            @RequestParam("departureDate") String departureDate
    ) {
        logger.info("Received request to search flights with departureId={}, arrivalId={}, departureDate={}", departureAirportId, arrivalAirportId, departureDate);

        // Call the flight service to perform the search
        List<SearchFlightResponse> foundFlights = flightService.searchFlights(departureAirportId, arrivalAirportId, departureDate);

        logger.info("Found {} flights for departureId={}, arrivalId={}, departureDate={}", foundFlights.size(), departureAirportId, arrivalAirportId, departureDate);
        // Return the results as a ResponseEntity
        return new ResponseEntity<>(foundFlights, HttpStatus.OK);
    }
}
