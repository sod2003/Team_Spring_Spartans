package com.skillstorm.spartanwireless.services;

import java.util.List;

import com.skillstorm.spartanwireless.dtos.DeviceRequestDto;
import com.skillstorm.spartanwireless.dtos.DeviceResponseDto;

public interface DeviceService {
    
    DeviceResponseDto createDevice(DeviceRequestDto deviceRequestDto);
    List<DeviceResponseDto> getAllDevices();
    DeviceResponseDto getDeviceById(Long deviceId);
    DeviceResponseDto updateDevice(Long deviceId, DeviceRequestDto deviceRequestDto);
    void deleteDevice(Long deviceId);
}
