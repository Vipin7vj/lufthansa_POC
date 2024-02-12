package com.lufthansa.flightbooking.controller;

import com.lufthansa.flightbooking.dto.BookingResponse;
import com.lufthansa.flightbooking.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void shouldReturnBookingsForValidUserId() {
        // Positive test case
        Long userId = 1L;

        // Mock response
        List<BookingResponse> mockBookings = createMockBookings();
        when(userService.getBookingsByUserId(anyLong())).thenReturn(mockBookings);

        // Call the controller method
        ResponseEntity<List<BookingResponse>> responseEntity = userController.getBookingsByUserId(userId);

        // Verify the result
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockBookings, responseEntity.getBody());
    }


    private List<BookingResponse> createMockBookings() {
        // Create and return mock booking data
        // You can customize this method to generate mock data based on your needs
        return Collections.singletonList(new BookingResponse(/* fill in the details */));
    }
}
