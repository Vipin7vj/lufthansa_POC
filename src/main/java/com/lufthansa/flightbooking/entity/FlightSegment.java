package com.lufthansa.flightbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSegment {

    private long id;
    private Airport airport;
    private Date dateTime;
}
