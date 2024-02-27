package com.skillstorm.spartanwireless.mappers;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;
import com.skillstorm.spartanwireless.models.Customer;

public class CustomerMapper {
    
    public static Customer mapToCustomer( CustomerRequestDto customerRequestDto) {
        return Customer
            .builder()
            .address(customerRequestDto.getAddress())
            .email(customerRequestDto.getEmail())
            .build();
    }

    public static CustomerResponseDto mapToCustomerResponseDto(Customer customer) {
        return CustomerResponseDto
            .builder()
            .custId(customer.getCustId())
            .address(customer.getAddress())
            .email(customer.getEmail())
            .phonePlans(customer.getPhonePlans())
            .isArchived(customer.isArchived())
            .lines(customer.getLines())
            .build();
    }
}
