package com.lufthansa.flightbooking.dto;

import com.lufthansa.flightbooking.entity.Airline;
import com.lufthansa.flightbooking.entity.Airport;

import javax.persistence.OneToOne;
import java.util.Date;

public class FlightRequest {
    private long id;
    private long flightNumber;
    private Integer duration;
    private Airline airline;
    private Airport arrival;
    private Airport departure;
    private Date arrivalTime;
    private Date departureTime;
    private long fare;
    private long seatCapacity;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public long getFare() {
        return fare;
    }

    public void setFare(long fare) {
        this.fare = fare;
    }

    public long getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(long seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
