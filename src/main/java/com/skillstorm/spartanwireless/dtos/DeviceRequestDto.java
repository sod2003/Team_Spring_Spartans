package com.skillstorm.spartanwireless.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeviceRequestDto {
    
    @NotBlank(message = "Device's name cannot be blank.")
    private String name;
    @NotBlank(message = "Device's brand cannot be blank.")
    private String brand;
    @NotBlank(message = "Device's price cannot be blank.")
    private double price;
}
