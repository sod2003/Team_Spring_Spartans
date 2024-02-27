package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.services.CustomerService;

import static com.skillstorm.spartanwireless.mappers.CustomerMapper.mapToCustomer;
import static com.skillstorm.spartanwireless.mappers.CustomerMapper.mapToCustomerResponseDto;;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        return mapToCustomerResponseDto(customerRepository.save(mapToCustomer(customerRequestDto)));
    }

    @Override
    public List<CustomerResponseDto> getAllActiveCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().filter(customer -> customer.isArchived() != true).map(customer -> mapToCustomerResponseDto(customer)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapToCustomerResponseDto(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDto getCustomerById(Long custId) {
        return mapToCustomerResponseDto(customerRepository.findById(custId).get());
    }

    @Override
    public CustomerResponseDto updateCustomer(Long custId, CustomerRequestDto customerRequestDto) {
        Customer customer = mapToCustomer(customerRequestDto);
        customer.setCustId(custId);
        return mapToCustomerResponseDto(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomerById(Long custId) {
        customerRepository.deleteById(custId);
    }

    
    
}
