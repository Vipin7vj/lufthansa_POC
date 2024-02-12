package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.BookingCancellationRequest;
import com.lufthansa.flightbooking.dto.BookingRequest;
import com.lufthansa.flightbooking.entity.Booking;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.entity.User;
import com.lufthansa.flightbooking.exception.SeatAvailabilityException;
import com.lufthansa.flightbooking.mapper.FlightMapper;
import com.lufthansa.flightbooking.mapper.UserMapper;
import com.lufthansa.flightbooking.repository.BookingRepository;
import com.lufthansa.flightbooking.repository.FlightRepository;
import com.lufthansa.flightbooking.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    public void saveBooking(BookingRequest bookingRequest) {
        User userEntity = UserMapper.INSTANCE.dtoToEntity(bookingRequest.getUser());

        Long flightId = bookingRequest.getFlightId();
        long requestedSeats = bookingRequest.getTravellers().size();

        long remainingSeatCapacity = updateSeatCapacity(flightId, -requestedSeats);
        validateSeatAvailability(remainingSeatCapacity);

        Flight flight = createFlight(flightId);
        logger.info("Saving booking for flight {} and {} travellers", flightId, requestedSeats);

        bookingRequest.getTravellers().forEach(traveller -> {
            Booking booking = createBooking(userEntity, flight, traveller);
            bookingRepository.save(booking);
        });
        logger.info("Booking process completed successfully");
    }

    private long updateSeatCapacity(Long flightId, Long requestedSeats) {
        long currentSeatCapacity = flightRepository.getSeatCapacityByFlightId(flightId);
        long remainingSeatCapacity = currentSeatCapacity + requestedSeats;
        flightRepository.updateSeatCapacityById(flightId, remainingSeatCapacity);
        return remainingSeatCapacity;
    }

    private void validateSeatAvailability(long remainingSeatCapacity) {
        if (remainingSeatCapacity < 0) {
            throw new SeatAvailabilityException("Not enough seats available for booking.");
        }
    }

    private Flight createFlight(Long flightId) {
        Flight flight = new Flight();
        flight.setId(flightId);
        return flight;
    }

    private Booking createBooking(User userEntity, Flight flight, String traveller) {
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setUser(userEntity);
        booking.setTravellerName(traveller);
        booking.setBookingStatus("Confirmed");
        return booking;
    }

    public void cancelBookings(BookingCancellationRequest request) {

        bookingRepository.cancelBookingsByIds(request.getBookingIds());
        long additionalSeats = request.getBookingIds().size();
        updateSeatCapacity(request.getFlightId(), additionalSeats);
        logger.info("Bookings cancelled successfully.");
    }
}
