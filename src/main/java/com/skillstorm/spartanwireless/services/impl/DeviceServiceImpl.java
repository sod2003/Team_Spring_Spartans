package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.DeviceRequestDto;
import com.skillstorm.spartanwireless.dtos.DeviceResponseDto;
import com.skillstorm.spartanwireless.models.Device;
import com.skillstorm.spartanwireless.repositories.DeviceRepository;
import com.skillstorm.spartanwireless.services.DeviceService;

import static com.skillstorm.spartanwireless.mappers.DeviceMapper.mapToDevice;
import static com.skillstorm.spartanwireless.mappers.DeviceMapper.mapToDeviceResponseDto;


@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository dr) {
        deviceRepository = dr;
    }

    @Override
    public DeviceResponseDto createDevice(DeviceRequestDto deviceRequestDto) {
        return mapToDeviceResponseDto(deviceRepository.save(mapToDevice(deviceRequestDto)));
    }

    @Override
    public List<DeviceResponseDto> getAllDevices() {
        return deviceRepository.findAll().stream().map((device) -> mapToDeviceResponseDto(device)).collect(Collectors.toList());
    }

    @Override
    public DeviceResponseDto getDeviceById(Long deviceId) {
        return mapToDeviceResponseDto(deviceRepository.findById(deviceId).get());
    }

    @Override
    public DeviceResponseDto updateDevice(Long deviceId, DeviceRequestDto deviceRequestDto) {
        Device device = deviceRepository.findById(deviceId).get();
        device.setName(deviceRequestDto.getName());
        device.setBrand(deviceRequestDto.getBrand());
        device.setPrice(deviceRequestDto.getPrice());
        return mapToDeviceResponseDto(deviceRepository.save(device));
    }

    @Override
    public void deleteDevice(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }
    
}
