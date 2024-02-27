package com.skillstorm.spartanwireless.services;

import java.util.List;

import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;

public interface PhoneLineService {
    
    PhoneLineResponseDto createPhoneLine(PhoneLineRequestDto phoneLineRequestDto);
    List<PhoneLineResponseDto> getAllPhoneLines();
    PhoneLineResponseDto getPhoneLineById(String phoneNumber);
    PhoneLineResponseDto updatePhoneLine(String phoneNumber, PhoneLineRequestDto phoneLineRequestDto);
    void deletePhoneLine(String phoneNumber);
}
