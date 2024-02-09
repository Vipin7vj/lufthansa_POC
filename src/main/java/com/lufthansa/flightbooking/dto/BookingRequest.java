package com.lufthansa.flightbooking.dto;

public class BookingRequest {
    private UserRequest user;
    private FlightRequest flightRequest;
    private int noOfTraveller;

    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

    public FlightRequest getFlightRequest() {
        return flightRequest;
    }

    public void setFlightRequest(FlightRequest flightRequest) {
        this.flightRequest = flightRequest;
    }

    public int getNoOfTraveller() {
        return noOfTraveller;
    }

    public void setNoOfTraveller(int noOfTraveller) {
        this.noOfTraveller = noOfTraveller;
    }
}
