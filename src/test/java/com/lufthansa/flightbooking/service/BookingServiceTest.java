package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.BookingCancellationRequest;
import com.lufthansa.flightbooking.dto.BookingRequest;
import com.lufthansa.flightbooking.dto.UserRequest;
import com.lufthansa.flightbooking.entity.Booking;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.entity.User;
import com.lufthansa.flightbooking.exception.SeatAvailabilityException;
import com.lufthansa.flightbooking.mapper.UserMapper;
import com.lufthansa.flightbooking.repository.BookingRepository;
import com.lufthansa.flightbooking.repository.FlightRepository;
import com.lufthansa.flightbooking.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void saveBooking_Success() {
        BookingRequest bookingRequest = createMockBookingRequest();
        when(flightRepository.getSeatCapacityByFlightId(anyLong())).thenReturn(10);

        bookingService.saveBooking(bookingRequest);

        verify(flightRepository, times(1)).getSeatCapacityByFlightId(anyLong());
        verify(flightRepository, times(1)).updateSeatCapacityById(anyLong(), anyLong());
        verify(bookingRepository, times(bookingRequest.getTravellers().size())).save(any(Booking.class));
    }

    @Test
    void cancelBookings_Success() {
        BookingCancellationRequest cancellationRequest = createMockCancellationRequest();
        doNothing().when(bookingRepository).cancelBookingsByIds(anyList());
        when(flightRepository.getSeatCapacityByFlightId(anyLong())).thenReturn(10);

        bookingService.cancelBookings(cancellationRequest);

        verify(bookingRepository, times(1)).cancelBookingsByIds(anyList());
        verify(flightRepository, times(1)).updateSeatCapacityById(anyLong(), anyLong());
    }

    private BookingRequest createMockBookingRequest() {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setUser(createMockUserDTO());
        bookingRequest.setFlightId(1L);
        bookingRequest.setTravellers(List.of("Traveller1", "Traveller2"));
        return bookingRequest;
    }

    private UserRequest createMockUserDTO() {
        UserRequest userDTO = new UserRequest();
        userDTO.setId(1);
        return userDTO;
    }

    private User createMockUserEntity() {
        User userEntity = UserMapper.INSTANCE.dtoToEntity(createMockUserDTO());
        userEntity.setId(1L);
        return userEntity;
    }

    private BookingCancellationRequest createMockCancellationRequest() {
        BookingCancellationRequest cancellationRequest = new BookingCancellationRequest();
        cancellationRequest.setFlightId(1L);
        cancellationRequest.setBookingIds(List.of(1L, 2L));
        return cancellationRequest;
    }
}
