package com.lufthansa.flightbooking.entity;

import com.lufthansa.flightbooking.enums.SeatCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private Long id;
    private SeatCategory category;
    private int seatNumber;
    private boolean isAvailable;
}
