package com.skillstorm.spartanwireless.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.spartanwireless.models.PhonePlan;

public interface PhonePlanRepository extends JpaRepository<PhonePlan, Long> {

    @Query("select p from PhonePlan p join p.customers c where c.custId = ?1")
    List<PhonePlan> findAll(Long custId);
}

