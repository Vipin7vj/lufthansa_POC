package com.lufthansa.flightbooking.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class BookingCancellationRequest {
    @NotEmpty(message = "Booking IDs cannot be empty")
    @Valid // Ensure that each element in the list is validated (e.g., not null)
    private List<@NotNull Long> bookingIds;

    @NotNull(message = "Flight ID cannot be null")
    @PositiveOrZero(message = "Flight ID must be positive or zero")
    private Long flightId;
    public List<Long> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<Long> bookingIds) {
        this.bookingIds = bookingIds;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
