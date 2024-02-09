package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.BookingRequest;
import com.lufthansa.flightbooking.entity.Booking;
import com.lufthansa.flightbooking.entity.Flight;
import com.lufthansa.flightbooking.entity.User;
import com.lufthansa.flightbooking.mapper.FlightMapper;
import com.lufthansa.flightbooking.mapper.UserMapper;
import com.lufthansa.flightbooking.repository.BookingRepository;
import com.lufthansa.flightbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public void saveBooking(BookingRequest bookingRequest) {
        User userEntity = UserMapper.INSTANCE.dtoToEntity(bookingRequest.getUser());
        Flight flight = FlightMapper.INSTANCE.dtoToEntity(bookingRequest.getFlightRequest());
        User user = userRepository.saveIfNotExists(userEntity);
        flight.setSeatCapacity(flight.getSeatCapacity()-bookingRequest.getNoOfTraveller());
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setUser(user);
        bookingRepository.save(booking);

    }
}
