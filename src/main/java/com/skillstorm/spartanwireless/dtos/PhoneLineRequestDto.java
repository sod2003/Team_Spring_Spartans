package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhoneLineRequestDto {
    
    private String phoneNumber;
    private Long deviceId;

}
