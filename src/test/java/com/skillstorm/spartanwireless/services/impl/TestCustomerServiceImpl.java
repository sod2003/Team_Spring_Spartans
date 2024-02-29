package com.skillstorm.spartanwireless.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class TestCustomerServiceImpl {
    
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private Long custId1;
    @Autowired
    private Customer customer1;
    @Autowired
    private Customer customer2;
    @Autowired
    private CustomerRequestDto customerRequestDto1;

    @BeforeEach
    public void init() {
        custId1 = 1L;
        customer1 = Customer.builder().custId(1L).name("Bob").address("121 Rock Rd.").email("bob@gmail.com").isArchived(false).build();
        customer2 = Customer.builder().custId(2L).name("Gil").address("59 Scenic St.").email("gil@gmail.com").isArchived(false).build();
        customerRequestDto1 = CustomerRequestDto.builder().name("Bob").address("121 Rock Rd.").email("bob@gmail.com").build();
    }

    @Test
    public void CustomerService_CreateCustomer_ReturnsCustomerResponseDto() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer1);
        CustomerResponseDto customerResponseDto = customerServiceImpl.createCustomer(customerRequestDto1);
        assertNotNull(customerResponseDto);
    }

    @Test
    public void CustomerService_GetAllActiveCustomers_ReturnsListOfCustomerReponseDto() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        when(customerRepository.findAll()).thenReturn(customers);
        List<CustomerResponseDto> customerResponseDtos = customerServiceImpl.getAllActiveCustomers();
        assertNotNull(customerResponseDtos);
    }

    @Test
    public void CustomerService_FindById_ReturnCustomerResponseDto() {
        when(customerRepository.findById(custId1)).thenReturn(Optional.ofNullable(customer1));
        CustomerResponseDto customerResponseDto = customerServiceImpl.getCustomerById(custId1);
        assertNotNull(customerResponseDto);
    }

    @Test
    public void CustomerService_UpdateCustomer_ReturnCustomerResponseDto() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer1);
        CustomerResponseDto customerResponseDto = customerServiceImpl.updateCustomer(custId1, customerRequestDto1);
        assertNotNull(customerResponseDto);
    }

    @Test
    public void CustomerService_DeleteCustomer_ReturnVoid() {
        customerServiceImpl.deleteCustomerById(custId1);
        verify(customerRepository, times(1)).deleteById(custId1);
    }
}