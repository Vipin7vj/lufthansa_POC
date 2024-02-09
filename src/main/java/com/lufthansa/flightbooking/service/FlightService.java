package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.mapper.FlightSearchMapper;
import com.lufthansa.flightbooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;



    public List<SearchFlightResponse> searchFlights(Long departureAirportId, Long arrivalAirportId, String departureDate) {
        // Call the custom query method from the repository
        List<Flight> flights = flightRepository.findFlightsByDepartureAndArrivalAndDate(departureAirportId, arrivalAirportId, departureDate);


        List<SearchFlightResponse> flightResponseList = new ArrayList<>();
        for (Flight flight : flights) {

            SearchFlightResponse flightResponse = FlightSearchMapper.INSTANCE.flightToSearchFlightResponse(flight);
            flightResponseList.add(flightResponse);
        }
        return flightResponseList;
    }

}
