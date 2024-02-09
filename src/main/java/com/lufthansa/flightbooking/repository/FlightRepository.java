package com.lufthansa.flightbooking.repository;

import com.lufthansa.flightbooking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.departure.id = :departureId AND f.arrival.id = :arrivalId AND DATE_FORMAT(f.departureTime, '%Y-%m-%d') = :departureDate")
    List<Flight> findFlightsByDepartureAndArrivalAndDate(
            @Param("departureId") Long departureId,
            @Param("arrivalId") Long arrivalId,
            @Param("departureDate") String departureDate
    );
}
