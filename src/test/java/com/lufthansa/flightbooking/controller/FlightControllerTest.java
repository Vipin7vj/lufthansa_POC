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
        // Positive test case
        Long departureAirportId = 1L;
        Long arrivalAirportId = 2L;
        String departureDate = "2022-02-15";
        Long noOfTraveller = 3L;

        List<SearchFlightResponse> mockFlights = createMockFlightList();
        when(flightService.searchFlights(anyLong(), anyLong(), anyString(), anyLong())).thenReturn(mockFlights);

        ResponseEntity<List<SearchFlightResponse>> responseEntity = flightController.searchFlights(departureAirportId, arrivalAirportId, departureDate, noOfTraveller);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockFlights, responseEntity.getBody());
    }


    private List<SearchFlightResponse> createMockFlightList() {
        // Create and return mock flight data
        // You can customize this method to generate mock data based on your needs
        return Collections.singletonList(new SearchFlightResponse(/* fill in the details */));
    }
}