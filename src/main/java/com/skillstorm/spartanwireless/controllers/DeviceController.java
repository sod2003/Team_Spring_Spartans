package com.skillstorm.spartanwireless.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spartanwireless.dtos.DeviceRequestDto;
import com.skillstorm.spartanwireless.dtos.DeviceResponseDto;
import com.skillstorm.spartanwireless.services.DeviceService;

import jakarta.validation.Valid;

/*Testing Branch */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/devices")
public class DeviceController {
    
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceResponseDto> createDevice(@Valid @RequestBody DeviceRequestDto deviceRequestDto) {
        return new ResponseEntity<>(deviceService.createDevice(deviceRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeviceResponseDto>> getAllDevices() {
        return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceResponseDto> getDeviceById(@PathVariable Long deviceId) {
       return new ResponseEntity<>(deviceService.getDeviceById(deviceId), HttpStatus.OK); 
    }

    @PutMapping("/{deviceId}")
    public ResponseEntity<DeviceResponseDto> updateDevice(@PathVariable Long deviceId, @RequestBody DeviceRequestDto deviceRequestDto) {
        return new ResponseEntity<>(deviceService.updateDevice(deviceId, deviceRequestDto), HttpStatus.OK);
    }
    
    @DeleteMapping("/{deviceId}")
    public void deleteDevice(@PathVariable Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }
}
