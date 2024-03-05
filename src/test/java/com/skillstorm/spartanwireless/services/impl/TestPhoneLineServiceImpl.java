package com.skillstorm.spartanwireless.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;
import com.skillstorm.spartanwireless.mappers.CustomerMapper;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.Device;
import com.skillstorm.spartanwireless.models.PhoneLine;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.repositories.PhoneLineRepository;

@ExtendWith(MockitoExtension.class)
public class TestPhoneLineServiceImpl {

    @Mock
    private PhoneLineRepository phoneLineRepository;

    @InjectMocks
    private PhoneLineServiceImpl phoneLineServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private String phoneNumber;

    @Autowired
    private PhoneLine phoneLine1;

    @Autowired
    private PhoneLine phoneLine2;

    @Autowired
    private Customer customer;

    @Autowired
    private PhoneLineRequestDto phoneLineRequestDto;

    @BeforeEach
    public void init(){
        phoneNumber = "404-687-5309";
        customer = Customer.builder().custId(1L).name("Bob").address("121 Rock Rd.").email("bob@gmail.com").isArchived(false).build();
        customerServiceImpl.createCustomer(CustomerRequestDto.builder().name("Bob").address("121 Rock Rd.").email("bob@gmail.com").build());
        phoneLine1 = PhoneLine.builder().phoneNumber("404-687-5309").customer(customer).device(Device.builder().deviceId(1L).build()).build();
        phoneLine1 = PhoneLine.builder().phoneNumber("404-687-5310").customer(customer).device(Device.builder().deviceId(2L).build()).build();
        phoneLineRequestDto = PhoneLineRequestDto.builder().phoneNumber(phoneNumber).deviceId(1L).build();
    }

    @Test
    public void PhoneLineService_CreatePhoneLine_ReturnsPhoneLineResponseDto() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        when(CustomerMapper.mapToCustomerResponseDto(any(Customer.class))).thenReturn(CustomerResponseDto.builder().custId(1L).name("Confused by Mocks").address("Worst idea lane").email("hopethisworks@google.com").build());
        when(customer.getCustId()).thenReturn(1L);
        when(phoneLineRepository.save(any(PhoneLine.class))).thenReturn(phoneLine1);
        PhoneLineResponseDto phoneLineResponseDto = phoneLineServiceImpl.createPhoneLine(1L, phoneLineRequestDto);
        assertNotNull(phoneLineResponseDto);
    }

    @Test
    public void PhoneLineService_GetAllPhoneLine_ReturnsListOfPhoneLineResponseDto() {
        List<PhoneLine> phoneLines = new ArrayList<>();
        phoneLines.add(phoneLine1);
        phoneLines.add(phoneLine2);
        when(phoneLineRepository.findAll()).thenReturn(phoneLines);
        List<PhoneLineResponseDto> phoneLineResponseDtos = phoneLineServiceImpl.getAllPhoneLines(1L);
        assertNotNull(phoneLineResponseDtos);
    }

    @Test
    public void PhoneLineService_GetPhoneLineById_ReturnsPhoneLineResponseDto() {
        when(phoneLineRepository.findById(phoneNumber)).thenReturn(Optional.ofNullable(phoneLine1));
        PhoneLineResponseDto phoneLineResponseDto = phoneLineServiceImpl.getPhoneLineById(phoneNumber);
        assertNotNull(phoneLineResponseDto);
    }
    
}
