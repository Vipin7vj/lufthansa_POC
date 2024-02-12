package com.lufthansa.flightbooking.repository;

import com.lufthansa.flightbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailId(String emailId);

    default User saveIfNotExists(User user) {
        Optional<User> existingUser = findByEmailId(user.getEmailId());

        if (existingUser.isPresent()) {
            return existingUser.get();
        } else {
            return save(user);
        }
    }
}
