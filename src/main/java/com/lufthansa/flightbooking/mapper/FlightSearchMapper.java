package com.lufthansa.flightbooking.mapper;

import com.lufthansa.flightbooking.dto.SearchFlightResponse;
import com.lufthansa.flightbooking.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FlightSearchMapper {
    FlightSearchMapper  INSTANCE = Mappers.getMapper(FlightSearchMapper.class);
    @Mapping(source = "airline.name", target = "airlineName")
    @Mapping(source = "departure.city", target = "departureCity")
    @Mapping(source = "arrival.city", target = "arrivalCity")
    @Mapping(target = "duration", expression = "java(formatDuration(flight.getDuration()))")
    SearchFlightResponse flightToSearchFlightResponse(Flight flight);

    default String formatDuration(Integer durationInMinutes) {
        // Your logic to format duration (e.g., convert minutes to hours and minutes)
        // This is just a placeholder, adjust it based on your requirements
        int hours = durationInMinutes / 60;
        int minutes = durationInMinutes % 60;
        return hours + "h " + minutes + "m";
    }

}
