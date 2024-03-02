package com.skillstorm.spartanwireless.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneLineRequestDto {
    
    private String phoneNumber;
    private Long deviceId;

}
