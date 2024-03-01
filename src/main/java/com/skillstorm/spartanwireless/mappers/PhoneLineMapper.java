package com.skillstorm.spartanwireless.mappers;

import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;
import com.skillstorm.spartanwireless.models.PhoneLine;

public class PhoneLineMapper {
    
    public static PhoneLine mapToPhoneLine(PhoneLineRequestDto phoneLineRequestDto) {
        return PhoneLine
            .builder()
            .phoneNumber(phoneLineRequestDto.getPhoneNumber())
            .build();
    }
    
    public static PhoneLineResponseDto mapToPhoneLineResponseDto(PhoneLine phoneLine) {
        return PhoneLineResponseDto
            .builder()
            .phoneNumber(phoneLine.getPhoneNumber())
            .build();
    }
}
