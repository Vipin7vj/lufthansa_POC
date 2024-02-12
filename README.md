# Flight Booking System

## Running the POC

1. **Database Setup:**
   - The database is automatically created with data insertion. Upon running the application after Maven install, the tables created and populated will be displayed.

2. **Authentication:**
   Once the application is started, access the Swagger UI using the URL: [Swagger UI](http://localhost:8080/swagger-ui/index.html/)

   As security has been implemented, obtain the token by hitting the token URL in the token controller. Get the access token with Bearer.

   Copy this token with Bearer. Click on "Authorize" and paste the token.

   After that, you will be able to access the other endpoints.

3. **Mapstruct Usage:**
   - Mapstruct, working at compile time, is used for DTO to entity and vice versa. Execute `mvn install` to check if mapper implementations are created in the target folder for mapping between entity and DTO.

## Flight Booking System

This repository hosts the source code for a comprehensive Flight Booking System, providing various functionalities for flight bookings and searches.

## Functionalities

### 1. Booking Functionalities
1. Create bookings for scheduled flights
2. Cancel bookings for specific flights

### 2. Search Scheduled and Available Flights
- Utilize the Search API to find available flights

### 3. Fetch My Bookings for a Specific User
- Retrieve all bookings associated with a particular user

## Prerequisites

1. **Master Tables:**
   - **Airline:** Represents various airlines such as Indigo, Go Air, etc.
   - **Flights:** Admins schedule flights in advance.
   - **Airport:** Encompasses a list of all available airports in different cities.
   - **Users:** Assumed to be added to the database during the login/signup process (outside the scope of this POC).

## Tech Stack

1. Spring Boot 2.7.0
2. Java 11
3. JPA for ORM
4. MySQL Database
5. Spring Security Okta for authentication, with Okta serving as the authentication and authorization server.
6. Mapstruct for DTO to entity mapping - Generates mappings at compile time.
7. Swagger for API testing and documentation
8. Validations using built-in annotations on POJOs and request params
9. Logging using SLF4J
10. Global exception handling
11. JavaDocs
12. JUnit Testing
