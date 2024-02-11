package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.exception.FlightNotFoundException;
import com.lufthansa.flightbooking.mapper.FlightSearchMapper;
import com.lufthansa.flightbooking.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);
    @Autowired
    private FlightRepository flightRepository;


    public List<SearchFlightResponse> searchFlights(Long departureAirportId, Long arrivalAirportId, String departureDate) {
        logger.info("Searching for flights with departureAirportId={}, arrivalAirportId={}, departureDate={}", departureAirportId, arrivalAirportId, departureDate);

        List<Flight> flights = flightRepository.findFlightsByDepartureAndArrivalAndDate(departureAirportId, arrivalAirportId, departureDate);

        if (flights.isEmpty()) {
            logger.warn("No flights found for departureAirportId={}, arrivalAirportId={}, departureDate={}", departureAirportId, arrivalAirportId, departureDate);
            throw new FlightNotFoundException(departureAirportId, arrivalAirportId, departureDate);
        }

        List<SearchFlightResponse> flightResponseList = flights.stream()
                .map(FlightSearchMapper.INSTANCE::flightToSearchFlightResponse)
                .collect(Collectors.toList());

        logger.info("Found {} flights for departureAirportId={}, arrivalAirportId={}, departureDate={}", flightResponseList.size(), departureAirportId, arrivalAirportId, departureDate);
        return flightResponseList;
    }

}
