package com.skillstorm.spartanwireless.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.spartanwireless.models.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(String username);
}
