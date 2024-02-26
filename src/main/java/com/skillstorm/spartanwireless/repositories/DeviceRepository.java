package com.skillstorm.spartanwireless.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.spartanwireless.models.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    
}
