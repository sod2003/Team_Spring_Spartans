package com.skillstorm.spartanwireless.services;

import java.util.List;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto getCustomerById(Long custId);
    CustomerResponseDto updateCustomer(Long custId, CustomerRequestDto customerRequestDto);
    void deleteCustomerById(Long custId);
    
}
