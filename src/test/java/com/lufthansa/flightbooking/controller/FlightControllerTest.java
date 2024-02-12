package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.controller.FlightController;
import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightControllerTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;


    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void shouldReturnFlightsOnValidSearchRequest() {
        Long departureAirportId = 1L;
        Long arrivalAirportId = 2L;
        String departureDate = "2022-02-15";
        Long noOfTraveller = 3L;

        List<SearchFlightResponse> mockFlights = createMockSearchFlightResponses();
        when(flightService.searchFlights(anyLong(), anyLong(), anyString(), anyLong())).thenReturn(mockFlights);

        ResponseEntity<List<SearchFlightResponse>> responseEntity = flightController.searchFlights(departureAirportId, arrivalAirportId, departureDate, noOfTraveller);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockFlights, responseEntity.getBody());
    }


    public List<SearchFlightResponse> createMockSearchFlightResponses() {
        List<SearchFlightResponse> responses = new ArrayList<>();

        // Create multiple SearchFlightResponse instances
        SearchFlightResponse response1 = createMockSearchFlightResponse("Airline1", "City1", "City2", 500, "2 hours", "12:00 PM", "2:00 PM");
        SearchFlightResponse response2 = createMockSearchFlightResponse("Airline2", "City3", "City4", 700, "3 hours", "3:00 PM", "6:00 PM");
        SearchFlightResponse response3 = createMockSearchFlightResponse("Airline3", "City5", "City6", 400, "1.5 hours", "9:00 AM", "10:30 AM");

        responses.add(response1);
        responses.add(response2);
        responses.add(response3);

        return responses;
    }

    private SearchFlightResponse createMockSearchFlightResponse(String airlineName, String departureCity,
                                                                String arrivalCity, int fare, String duration,
                                                                String arrivalTime, String departureTime) {
        SearchFlightResponse response = new SearchFlightResponse();
        response.setAirlineName(airlineName);
        response.setDepartureCity(departureCity);
        response.setArrivalCity(arrivalCity);
        response.setFare(fare);
        response.setDuration(duration);
        response.setArrivalTime(arrivalTime);
        response.setDepartureTime(departureTime);
        return response;
    }

}