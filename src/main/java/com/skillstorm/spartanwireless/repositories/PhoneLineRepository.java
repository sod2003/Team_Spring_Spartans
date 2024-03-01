package com.skillstorm.spartanwireless.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.PhoneLine;

public interface PhoneLineRepository extends JpaRepository<PhoneLine, String> {
    
    @Query("select p from PhoneLine p where p.customer = ?1")
    List<PhoneLine> findAll(Customer customer);
}
