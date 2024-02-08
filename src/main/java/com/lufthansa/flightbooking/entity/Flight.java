package com.lufthansa.flightbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long flightNumber;
    private Duration duration;
    @OneToMany
    @JoinColumn(name = "flight_id")
    private List<Seat> seats;
    private String airline;
    @OneToOne
    private FlightSegment arrival;
    @OneToOne
    private FlightSegment departure;
    private long fare;

}
