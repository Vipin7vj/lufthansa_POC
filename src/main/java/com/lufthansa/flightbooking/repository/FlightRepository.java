package com.lufthansa.flightbooking.repository;

import com.lufthansa.flightbooking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("UPDATE Flight f SET f.seatCapacity = :reducedSeat WHERE f.id = :flightId")
    void reduceSeatCapacityById(@Param("flightId") long flightId, @Param("reducedSeat") long reducedSeat);

    @Query("SELECT f.seatCapacity FROM Flight f WHERE f.id = :flightId")
    Long getSeatCapacityByFlightId(@Param("flightId") Long flightId);
}
