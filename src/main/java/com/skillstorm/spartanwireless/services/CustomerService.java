package com.skillstorm.spartanwireless.services;

import java.util.List;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAllCustomers();
    List<CustomerResponseDto> getAllActiveCustomers();
    CustomerResponseDto getCustomerById(Long custId);
    CustomerResponseDto updateCustomer(Long custId, CustomerRequestDto customerRequestDto);
    String deleteCustomerById(Long custId);
    
}
