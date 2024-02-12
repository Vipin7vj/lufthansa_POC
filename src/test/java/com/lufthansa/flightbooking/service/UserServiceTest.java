package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.entity.Booking;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.entity.User;
import com.lufthansa.flightbooking.mapper.BookingMapper;
import com.lufthansa.flightbooking.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getBookingsByUserId_Success() {
        Long userId = 1L;
        List<Booking> mockBookings = createMockBookings();
        when(bookingRepository.findByUserId(userId)).thenReturn(mockBookings);

        List<BookingResponse> result = userService.getBookingsByUserId(userId);

        assertEquals(mockBookings.size(), result.size());

        Mockito.verify(bookingRepository, Mockito.times(1)).findByUserId(anyLong());
    }

    public List<Booking> createMockBookings() {
        List<Booking> bookings = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setUser(new User());
        booking.setFlight(new Flight());
        booking.setTravellerName("Mock Traveller");
        booking.setBookingStatus("Confirmed");
        bookings.add(booking);
        return bookings;
    }

    public static BookingResponse createMockBookingResponse() {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setName("Mock Traveller");
        bookingResponse.setDepartureAirport("Departure Airport");
        bookingResponse.setArrivalAirport("Arrival Airport");
        bookingResponse.setAirline("Mock Airline");
        bookingResponse.setDuration("2 hours");
        bookingResponse.setFare(100);
        bookingResponse.setArrivalTime(new Date());
        bookingResponse.setDepartureTime(new Date());
        return bookingResponse;
    }
}
