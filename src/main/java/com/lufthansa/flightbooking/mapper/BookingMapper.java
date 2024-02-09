package com.lufthansa.flightbooking.mapper;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "name", source = "travellerName")
    @Mapping(target = "departureAirport", source = "flight.departure.name")
    @Mapping(target = "arrivalAirport", source = "flight.arrival.name")
    @Mapping(target = "airline", source = "flight.airline.name")
    @Mapping(target = "duration", source = "flight.duration")
    @Mapping(target = "fare", source = "flight.fare")
    @Mapping(target = "arrivalTime", source = "flight.arrivalTime")
    @Mapping(target = "departureTime", source = "flight.departureTime")
    BookingResponse bookingToBookingResponse(Booking booking);

}
