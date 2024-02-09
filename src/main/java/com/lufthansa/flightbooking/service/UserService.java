package com.lufthansa.flightbooking.service;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.entity.Booking;
import com.lufthansa.flightbooking.mapper.BookingMapper;
import com.lufthansa.flightbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingResponse> getBookingsByUserId(Long userId) {
        List<Booking> bookings =  bookingRepository.findByUserId(userId);
        List<BookingResponse> response = new ArrayList<>();

        bookings.forEach(b->{
            BookingResponse bookingResponse = BookingMapper.INSTANCE.bookingToBookingResponse(b);
            response.add(bookingResponse);
        });

        return response;
    }

}
