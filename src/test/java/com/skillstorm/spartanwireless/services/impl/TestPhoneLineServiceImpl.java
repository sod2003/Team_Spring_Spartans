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

import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.Device;
import com.skillstorm.spartanwireless.models.PhoneLine;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.repositories.DeviceRepository;
import com.skillstorm.spartanwireless.repositories.PhoneLineRepository;

@ExtendWith(MockitoExtension.class)
public class TestPhoneLineServiceImpl {

    @Mock
    private PhoneLineRepository phoneLineRepository;

    @InjectMocks
    private PhoneLineServiceImpl phoneLineServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private DeviceRepository deviceRepository;

    @Autowired
    private String phoneNumber;

    @Autowired
    private PhoneLine phoneLine1;

    @Autowired
    private PhoneLine phoneLine2;

    @Autowired
    private Long custId;

    @Autowired
    private Customer customer;

    @Autowired
    private Long deviceId;

    @Autowired
    private Device device;

    @BeforeEach
    public void init(){
        phoneNumber = "404-687-5309";
        custId = 1L;
        customer = Customer.builder().custId(custId).name("Bob").address("121 Rock Rd.").email("bob@gmail.com").isArchived(false).build();
        deviceId = 1L;
        device = Device.builder().deviceId(deviceId).name("iPhone X").brand("Apple").price(999.99).build();
        phoneLine1 = PhoneLine.builder().phoneNumber("404-687-5309").customer(customer).device(Device.builder().deviceId(1L).build()).build();
        phoneLine1 = PhoneLine.builder().phoneNumber("404-687-5310").customer(customer).device(Device.builder().deviceId(2L).build()).build();
    }

    @Test
    public void PhoneLineService_CreatePhoneLine_ReturnsPhoneLineResponseDto() {
        when(customerRepository.findById(custId)).thenReturn(Optional.ofNullable(customer));
        when(phoneLineRepository.save(any(PhoneLine.class))).thenReturn(phoneLine1);
        when(deviceRepository.findById(deviceId)).thenReturn(Optional.ofNullable(device));
        PhoneLineResponseDto phoneLineResponseDto = phoneLineServiceImpl.createPhoneLine(custId, deviceId);
        assertNotNull(phoneLineResponseDto);
    }

    @Test
    public void PhoneLineService_GetAllPhoneLine_ReturnsListOfPhoneLineResponseDto() {
        List<PhoneLine> phoneLines = new ArrayList<>();
        phoneLines.add(phoneLine1);
        phoneLines.add(phoneLine2);
        when(customerRepository.findById(custId)).thenReturn(Optional.ofNullable(customer));
        List<PhoneLineResponseDto> phoneLineResponseDtos = phoneLineServiceImpl.getAllPhoneLines(custId);
        assertNotNull(phoneLineResponseDtos);
    }

    @Test
    public void PhoneLineService_GetPhoneLineById_ReturnsPhoneLineResponseDto() {
        when(phoneLineRepository.findById(phoneNumber)).thenReturn(Optional.ofNullable(phoneLine1));
        PhoneLineResponseDto phoneLineResponseDto = phoneLineServiceImpl.getPhoneLineById(phoneNumber);
        assertNotNull(phoneLineResponseDto);
    }
    
}
