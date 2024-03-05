package com.skillstorm.spartanwireless.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;
import com.skillstorm.spartanwireless.exceptions.PhonePlanNotPurchasedException;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.PhonePlan;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.repositories.PhonePlanRepository;

@ExtendWith(MockitoExtension.class)
public class TestPhonePlanServiceImpl {
    
    @Mock
    private PhonePlanRepository phonePlanRepository;
    @Mock 
    private CustomerRepository customerRepository;

    @InjectMocks
    private PhonePlanServiceImpl phonePlanServiceImpl;

    @Autowired
    private Long phonePlanId1;
    @Autowired
    private PhonePlan phonePlan1;
    @Autowired
    private PhonePlan phonePlan2;
    @Autowired
    private Long custId1;
    @Autowired
    private Customer customer1;
    @Autowired
    private List<PhonePlan> phonePlanList;

    @BeforeEach
    public void init() {
        custId1 = 1L;
        phonePlanId1 = 1L;
        phonePlanList = new ArrayList<PhonePlan>();
        phonePlan1 = PhonePlan.builder().phoneLines(1).dataLimit(10).cost(49.99).build();
        phonePlan2 = PhonePlan.builder().phoneLines(2).dataLimit(15).cost(59.99).build();
        customer1 = Customer.builder().custId(1L).name("Bob").address("121 Rock Rd.").email("bob@gmail.com").isArchived(false).build();
    }

    @Test
    public void PhonePlanService_CreatePhonePlan_ReturnsPhonePlanResponseDto() {
        // ARRANGE
        phonePlanList.add(phonePlan1);
        customer1.setPhonePlans(phonePlanList);
        // ACT
        when(phonePlanRepository.findById(phonePlanId1)).thenReturn(Optional.ofNullable(phonePlan1));
        when(customerRepository.findById(custId1)).thenReturn(Optional.ofNullable(customer1));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer1);
        PhonePlanResponseDto phonePlanResponseDto = phonePlanServiceImpl.createPhonePlan(custId1, phonePlanId1);
        // ASSERT
        assertNotNull(phonePlanResponseDto);
    }

    @Test
    public void PhonePlanService_GetAllPhonePlansByCustId_ReturnsListOfPhonePlanReponseDto() {
        // ARRANGE
        phonePlanList.add(phonePlan1);
        phonePlanList.add(phonePlan2);
        // ACT
        when(phonePlanRepository.findAll(custId1)).thenReturn(phonePlanList);
        List<PhonePlanResponseDto> phonePlanResponseDtoList = phonePlanServiceImpl.getAllPhonePlansByCustId(custId1);
        // ASSERT
        assertNotNull(phonePlanResponseDtoList);
    }

    @Test
    public void PhonePlanService_FindById_ReturnCustomerResponseDto() {
        // ARRANGE
        phonePlanList.add(phonePlan1);
        customer1.setPhonePlans(phonePlanList);
        // ACT
        when(customerRepository.findById(custId1)).thenReturn(Optional.ofNullable(customer1));
        // ASSERT
        assertThrows(PhonePlanNotPurchasedException.class, () -> phonePlanServiceImpl.getPhonePlanById(custId1, phonePlanId1));
    }

    /* 
    (Comment in MAIN controller for UPDATE) There are only 3 Plans that Spartan 
    Wireless provides. The plans cannot be altered in themselves. However, the
    plans can be added onto and removed from customers as needed or not. 
    */ 


}