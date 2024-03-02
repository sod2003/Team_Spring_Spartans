package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhoneLineResponseDto {
    
    private String phoneNumber;
    private DeviceResponseDto deviceResponseDto;
}
