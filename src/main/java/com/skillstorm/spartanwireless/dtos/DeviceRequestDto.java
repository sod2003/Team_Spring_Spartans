package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeviceRequestDto {
    
    private String name;
    private String brand;
}
