package com.lufthansa.flightbooking.repository;

import com.lufthansa.flightbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    @Modifying
    @Query("UPDATE Booking b SET b.bookingStatus = 'Cancelled' WHERE b.id IN :ids")
    void cancelBookingsByIds(@Param("ids") List<Long> ids);
}
