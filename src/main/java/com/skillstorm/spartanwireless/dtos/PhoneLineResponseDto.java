package com.skillstorm.spartanwireless.dtos;

import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.Device;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhoneLineResponseDto {
    
    private String phoneNumber;
    private Customer customer;
    private Device device;
}
