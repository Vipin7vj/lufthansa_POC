package com.lufthansa.flightbooking.mapper;

import com.lufthansa.flightbooking.dto.UserRequest;
import com.lufthansa.flightbooking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //@Mapping(target = "id", ignore = true)
        // Ignore id during mapping (for creating a new entity)
    User dtoToEntity(UserRequest userRequest);

    UserRequest entityToDto(User user);
}
