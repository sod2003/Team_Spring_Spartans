package com.skillstorm.spartanwireless.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.spartanwireless.models.PhonePlan;

public interface PhonePlanRepository extends JpaRepository<PhonePlan, Long> {
    
}
