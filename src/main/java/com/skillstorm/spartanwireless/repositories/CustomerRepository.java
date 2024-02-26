package com.skillstorm.spartanwireless.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.spartanwireless.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
