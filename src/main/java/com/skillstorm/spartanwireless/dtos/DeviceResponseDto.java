package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceResponseDto {
    
    private Long deviceId;
    private String name;
    private String brand;
    private double price;
}
