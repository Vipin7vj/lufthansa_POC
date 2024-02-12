package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.entity.Airline;
import com.lufthansa.flightbooking.entity.Airport;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.exception.FlightNotFoundException;
import com.lufthansa.flightbooking.mapper.FlightSearchMapper;
import com.lufthansa.flightbooking.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private FlightSearchMapper flightSearchMapper;

    @InjectMocks
    private FlightService flightService;

    @Test
    void searchFlights_Success() {
        Long departureAirportId = 1L;
        Long arrivalAirportId = 2L;
        String departureDate = "2024-02-12";
        Long noOfTraveller = 2L;

        List<Flight> mockFlights = new ArrayList<>();
        mockFlights.add(createMockFlight());

        when(flightRepository.findFlightsByDepartureAndArrivalAndDateAndCapacity(anyLong(), anyLong(), anyString(), anyLong()))
                .thenReturn(mockFlights);

        List<SearchFlightResponse> result = flightService.searchFlights(departureAirportId, arrivalAirportId, departureDate, noOfTraveller);
        assertTrue(!result.isEmpty());

    }

    @Test
    void searchFlights_NoFlightsFound() {
        Long departureAirportId = 1L;
        Long arrivalAirportId = 2L;
        String departureDate = "2024-02-12";
        Long noOfTraveller = 2L;

        when(flightRepository.findFlightsByDepartureAndArrivalAndDateAndCapacity(anyLong(), anyLong(), anyString(), anyLong()))
                .thenReturn(new ArrayList<>());

        assertThrows(FlightNotFoundException.class,
                () -> flightService.searchFlights(departureAirportId, arrivalAirportId, departureDate, noOfTraveller));

        verify(flightRepository, times(1))
                .findFlightsByDepartureAndArrivalAndDateAndCapacity(eq(departureAirportId), eq(arrivalAirportId), eq(departureDate), eq(noOfTraveller));

        verifyNoInteractions(flightSearchMapper);
    }

    public Flight createMockFlight() {
        Flight flight = new Flight();
        flight.setId(1L);
        flight.setFlightNumber(12345L);
        flight.setDuration(120);

        Airline airline = createMockAirline();
        Airport arrivalAirport = createMockAirport("ArrivalCity", "ArrivalCountry", "ArrivalAirport");
        Airport departureAirport = createMockAirport("DepartureCity", "DepartureCountry", "DepartureAirport");

        flight.setAirline(airline);
        flight.setArrival(arrivalAirport);
        flight.setDeparture(departureAirport);

        flight.setArrivalTime(new Date());
        flight.setDepartureTime(new Date());
        flight.setFare(500L);
        flight.setSeatCapacity(200L);

        return flight;
    }

    public static Airport createMockAirport(String city, String country, String name) {
        Airport airport = new Airport();
        airport.setId(1L);
        airport.setCity(city);
        airport.setCountry(country);
        airport.setName(name);
        return airport;
    }

    public static Airline createMockAirline() {
        Airline airline = new Airline();
        airline.setId(1L);
        airline.setName("Mock Airline");
        airline.setCode("MA");
        return airline;
    }

    public SearchFlightResponse createMockSearchFlightResponse() {
        SearchFlightResponse response = new SearchFlightResponse();

        Flight mockFlight = createMockFlight();
        response.setDuration("2h30m");
        response.setAirlineName(mockFlight.getAirline().getName());
        response.setArrivalCity(mockFlight.getArrival().getCity());
        response.setDepartureCity(mockFlight.getDeparture().getCity());
        response.setArrivalTime(mockFlight.getArrivalTime().toString());
        response.setDepartureTime(mockFlight.getDepartureTime().toString());
        response.setFare(2);

        return response;
    }
}
