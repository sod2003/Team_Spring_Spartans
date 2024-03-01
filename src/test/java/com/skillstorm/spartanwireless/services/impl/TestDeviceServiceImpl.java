package com.skillstorm.spartanwireless.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.spartanwireless.dtos.DeviceRequestDto;
import com.skillstorm.spartanwireless.dtos.DeviceResponseDto;
import com.skillstorm.spartanwireless.models.Device;
import com.skillstorm.spartanwireless.repositories.DeviceRepository;

@ExtendWith(MockitoExtension.class)
public class TestDeviceServiceImpl {

    @Mock
    private DeviceRepository deviceRepository;

    @InjectMocks
    private DeviceServiceImpl deviceServiceImpl;

    @Autowired
    private Long deviceID;

    @Autowired
    private Device testDevice1;

    @Autowired
    private Device testDevice2;

    @Autowired
    private DeviceRequestDto deviceRequestDto;

    @BeforeEach
    public void init() {
        deviceID = 1L;
        testDevice1 = Device.builder().deviceId(1L).name("iPhone X").brand("Apple").price(999.99).build();
        testDevice2 = Device.builder().deviceId(2L).name("Galaxy S20").brand("Samsung").price(899.99).build();
        deviceRequestDto = DeviceRequestDto.builder().name("iPhone X").brand("Apple").build();
    }

    @Test
    public void DeviceService_CreateDevice_ReturnsDeviceResponseDto() {
        when(deviceRepository.save(any(Device.class))).thenReturn(testDevice1);
        DeviceResponseDto deviceResponseDto = deviceServiceImpl.createDevice(deviceRequestDto);
        assertNotNull(deviceResponseDto);
    }

    @Test
    public void DeviceService_GetAllDevices_ReturnsListOfDeviceResponseDto() {
        List<Device> devices = new ArrayList<>();
        devices.add(testDevice1);
        devices.add(testDevice2);
        when(deviceRepository.findAll()).thenReturn(devices);
        List<DeviceResponseDto> deviceResponseDtos = deviceServiceImpl.getAllDevices();
        assertNotNull(deviceResponseDtos); 
    }

    @Test
    public void DeviceService_FindById_ReturnDeviceResponseDto() {
        when(deviceRepository.findById(deviceID)).thenReturn((Optional.ofNullable(testDevice1)));
        DeviceResponseDto deviceResponseDto = deviceServiceImpl.getDeviceById(deviceID);
        assertNotNull(deviceResponseDto);
    }

    @Test
    public void DeviceService_UpdateDevice_ReturnDeviceResponseDto() {
        when(deviceRepository.save(any(Device.class))).thenReturn(testDevice1);
        DeviceResponseDto deviceResponseDto = deviceServiceImpl.updateDevice(deviceID, deviceRequestDto);
        assertNotNull(deviceResponseDto);
    }
    
}
