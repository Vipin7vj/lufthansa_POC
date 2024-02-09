package com.lufthansa.flightbooking.dto;

import java.util.List;

public class BookingRequest {
    private UserRequest user;
    private long flightId;
    private List<String> travellers;


    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public List<String> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<String> travellers) {
        this.travellers = travellers;
    }
}
