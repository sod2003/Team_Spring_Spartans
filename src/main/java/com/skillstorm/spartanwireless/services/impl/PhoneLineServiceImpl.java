package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;
import com.skillstorm.spartanwireless.models.Customer;
import com.skillstorm.spartanwireless.models.Device;
import com.skillstorm.spartanwireless.models.PhoneLine;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.repositories.DeviceRepository;
import com.skillstorm.spartanwireless.repositories.PhoneLineRepository;
import com.skillstorm.spartanwireless.services.PhoneLineService;

import static com.skillstorm.spartanwireless.mappers.PhoneLineMapper.mapToPhoneLine;
import static com.skillstorm.spartanwireless.mappers.PhoneLineMapper.mapToPhoneLineResponseDto;

@Service
public class PhoneLineServiceImpl implements PhoneLineService {

    @Autowired
    private PhoneLineRepository phoneLineRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public PhoneLineResponseDto createPhoneLine(Long custId, PhoneLineRequestDto phoneLineRequestDto) {
        Customer customer = customerRepository.findById(custId).get();
        Device device = deviceRepository.findById(phoneLineRequestDto.getDeviceId()).get();
        PhoneLine phoneLine = mapToPhoneLine(phoneLineRequestDto);
        phoneLine.setCustomer(customer);
        phoneLine.setDevice(device);
        return mapToPhoneLineResponseDto(phoneLineRepository.save(phoneLine));
    }

    @Override
    public List<PhoneLineResponseDto> getAllPhoneLines(Long custId) {
        Customer customer = customerRepository.findById(custId).get();
        return phoneLineRepository.findAll(customer).stream().map((phoneLine) -> mapToPhoneLineResponseDto(phoneLine)).collect(Collectors.toList());
    }

    @Override
    public PhoneLineResponseDto getPhoneLineById(String phoneNumber) {
        return mapToPhoneLineResponseDto(phoneLineRepository.findById(phoneNumber).get());
    }

    /*
    (Comment in Controller)
    @Override
    public PhoneLineResponseDto updatePhoneLine(String phoneNumber, PhoneLineRequestDto phoneLineRequestDto) {
        PhoneLine phoneLine = phoneLineRepository.findById(phoneNumber).get();
        phoneLine.setPhoneNumber(phoneLineRequestDto.getPhoneNumber());
        return mapToPhoneLineResponseDto(phoneLineRepository.save(phoneLine));
    }
    */

    @Override
    public void deletePhoneLine(String phoneNumber) {
        phoneLineRepository.deleteById(phoneNumber);
    }
    
}
