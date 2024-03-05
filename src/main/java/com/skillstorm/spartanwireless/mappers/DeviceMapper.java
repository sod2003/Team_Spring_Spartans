package com.skillstorm.spartanwireless.mappers;

import com.skillstorm.spartanwireless.dtos.DeviceRequestDto;
import com.skillstorm.spartanwireless.dtos.DeviceResponseDto;
import com.skillstorm.spartanwireless.models.Device;

public class DeviceMapper {
    
    public static Device mapToDevice(DeviceRequestDto deviceRequestDto) {
        return Device
            .builder()
            .name(deviceRequestDto.getName())
            .brand(deviceRequestDto.getBrand())
            .price(deviceRequestDto.getPrice())
            .build();
    }

    public static DeviceResponseDto mapToDeviceResponseDto(Device device) {
        return DeviceResponseDto
            .builder()
            .deviceId(device.getDeviceId())
            .name(device.getName())
            .brand(device.getBrand())
            .price(device.getPrice())
            .build();
    }
}
