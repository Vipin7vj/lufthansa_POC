package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.service.UserService;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void shouldReturnBookingsForValidUserId() {
        Long userId = 1L;
        List<BookingResponse> mockBookings = createMockBookingResponses();
        when(userService.getBookingsByUserId(anyLong())).thenReturn(mockBookings);
        ResponseEntity<List<BookingResponse>> responseEntity = userController.getBookingsByUserId(userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBookings, responseEntity.getBody());
    }



    public static List<BookingResponse> createMockBookingResponses() {
        List<BookingResponse> responses = new ArrayList<>();
        BookingResponse response1 = createMockBookingResponse("John Doe", "City1", "City2", "Airline1", "2 hours", 500);
        BookingResponse response2 = createMockBookingResponse("Jane Doe", "City3", "City4", "Airline2", "3 hours", 700);
        BookingResponse response3 = createMockBookingResponse("Alice Smith", "City5", "City6", "Airline3", "1.5 hours", 400);
        responses.add(response1);
        responses.add(response2);
        responses.add(response3);
        return responses;
    }

    private static BookingResponse createMockBookingResponse(String name, String departureAirport, String arrivalAirport,
                                                             String airline, String duration, int fare) {
        BookingResponse response = new BookingResponse();
        response.setName(name);
        response.setDepartureAirport(departureAirport);
        response.setArrivalAirport(arrivalAirport);
        response.setAirline(airline);
        response.setDuration(duration);
        response.setFare(fare);
        response.setArrivalTime(new Date());
        response.setDepartureTime(new Date());
        return response;
    }
}
