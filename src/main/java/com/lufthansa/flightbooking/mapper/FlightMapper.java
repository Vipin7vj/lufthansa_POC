package com.lufthansa.flightbooking.mapper;

import com.lufthansa.flightbooking.dto.FlightRequest;
import com.lufthansa.flightbooking.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FlightMapper {

    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    //@Mapping(target = "id", ignore = true) // Ignore id during mapping (for creating a new entity)
    @Mapping(target = "airline", source = "airline")
    @Mapping(target = "arrival", source = "arrival")
    @Mapping(target = "departure", source = "departure")
    Flight dtoToEntity(FlightRequest flightRequest);
}
