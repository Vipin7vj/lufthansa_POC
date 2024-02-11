package com.lufthansa.flightbooking.dto;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class BookingRequest {

    @NotNull(message = "User information cannot be null")
    @Valid
    private UserRequest user;

    @NotNull(message = "Flight ID cannot be null")
    @Max(10)
    private Long flightId;

    @NotEmpty(message = "Travellers list cannot be empty")
    @Size(min = 1, message = "At least one traveler must be specified")
    private List<@NotBlank(message = "Traveller name cannot be blank")
    @Size(max = 50, message = "Traveller name must not exceed 50 characters") String> travellers;

    // Getters and setters
    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public List<String> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<String> travellers) {
        this.travellers = travellers;
    }
}
