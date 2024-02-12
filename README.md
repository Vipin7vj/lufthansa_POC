Certainly! Here is a sample README.md file for your Git repository:

---

# Flight Booking System

This repository contains the source code for a Flight Booking System, providing various functionalities for flight bookings and searches.

## Functionalities

### 1. Booking Functionalities
   1. Create a booking on a scheduled flight
   2. Cancel your booking for a particular flight

### 2. Search scheduled and available Flights
   - Search API available

### 3. Fetch My Bookings for a specific user
   - Find all bookings done by a user

## Prerequisites

1. Master Tables:
   - **Airline:** Represents airlines like Indigo, Go Air, etc.
   - **Flights:** Must be scheduled earlier by admins.
   - **Airport:** Lists all airports available in cities.
   - **Users:** Assumed to be added to the database during the login/signup process (out of scope for this POC).

## Running the POC

1. **Database Setup:**
   - A database is created with data inserted automatically. Running the application after Maven install will display the created and populated tables.

2. **Authentication:**
   - Obtain a token by hitting a Postman API. All subsequent APIs require this token for access.

3. **Mapstruct Usage:**
   - Mapstruct, which works at compile time, is used for DTO to entity and vice versa. Execute `mvn install` to check if mapper implementations are created in the target folder for mapping between entity and DTO.

## Tech Stack

1. Spring Boot 2.7.0
2. Java 11
3. JPA for ORM
4. MySQL Database
5. Spring Security Okta for authentication. Okta serves as our authentication and authorization server.
6. Mapstruct for DTO to entity mapping - Generates mappings at compile time.
7. Swagger for API testing and documentation
8. Validations using inbuilt annotations on POJOs and request params
9. Logging using SLF4J
10. Global exception handling
11. JavaDocs
12. JUnit Testing

---

Feel free to customize and expand upon this template based on your specific requirements and details about your project.
