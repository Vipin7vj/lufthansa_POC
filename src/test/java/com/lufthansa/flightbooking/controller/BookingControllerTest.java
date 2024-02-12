package com.lufthansa.flightbooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lufthansa.flightbooking.dto.BookingCancellationRequest;
import com.lufthansa.flightbooking.dto.BookingRequest;
import com.lufthansa.flightbooking.dto.UserRequest;
import com.lufthansa.flightbooking.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Test
    void saveBooking_Success() throws Exception {
        BookingRequest bookingRequest = createMockBookingRequest();
        doNothing().when(bookingService).saveBooking(any(BookingRequest.class));
        ResponseEntity<String> responseEntity = bookingController.saveBooking(bookingRequest);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void cancelBookings_Success() throws Exception {
        BookingCancellationRequest cancellationRequest = createMockCancellationRequest();
        doNothing().when(bookingService).cancelBookings(any(BookingCancellationRequest.class));

        ResponseEntity<String> responseEntity = bookingController.cancelBookings(cancellationRequest);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    public BookingCancellationRequest createMockCancellationRequest() {
        BookingCancellationRequest cancellationRequest = new BookingCancellationRequest();
        cancellationRequest.setBookingIds(Arrays.asList(1L, 2L, 3L));
        cancellationRequest.setFlightId(123L);
        return cancellationRequest;
    }

    public BookingRequest createMockBookingRequest() {
        BookingRequest bookingRequest = new BookingRequest();

        UserRequest userRequest = new UserRequest();
        userRequest.setName("John");
        userRequest.setEmailId("john.doe@example.com");
        bookingRequest.setUser(userRequest);

        bookingRequest.setFlightId(123L);

        bookingRequest.setTravellers(Arrays.asList("Traveler1", "Traveler2"));

        return bookingRequest;
    }

}


