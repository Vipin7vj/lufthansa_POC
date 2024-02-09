package com.lufthansa.flightbooking.repository;

import com.lufthansa.flightbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailId(String emailId);

    default User saveIfNotExists(User user) {
        // Check if a user with the given email already exists
        Optional<User> existingUser = findByEmailId(user.getEmailId());

        if (existingUser.isPresent()) {
            // User with the given email already exists, do nothing
            return existingUser.get();
        } else {
            // User with the given email doesn't exist, save the new user
            return save(user);
        }
    }
}
