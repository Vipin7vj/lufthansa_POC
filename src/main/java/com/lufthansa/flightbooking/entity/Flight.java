package com.lufthansa.flightbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;
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
    private Integer duration;
    private String airline;
    @OneToOne
    private Airport arrival;
    @OneToOne
    private Airport departure;
    private Date arrivalTime;
    private Date departureTime;
    private long fare;
    private long seatCapacity;

}
