package com.skillstorm.spartanwireless.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.spartanwireless.models.PhoneLine;

public interface PhoneLineRepository extends JpaRepository<PhoneLine, String> {
    
}
