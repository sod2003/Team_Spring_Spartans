package com.skillstorm.spartanwireless.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spartanwireless.dtos.PhoneLineRequestDto;
import com.skillstorm.spartanwireless.dtos.PhoneLineResponseDto;
import com.skillstorm.spartanwireless.services.PhoneLineService;

@RestController
@RequestMapping("customers/{custId}/lines")
public class PhoneLineController {
    
    @Autowired
    private PhoneLineService phoneLineService;

    @PostMapping
    public ResponseEntity<PhoneLineResponseDto> createPhoneLine(@PathVariable Long custId, @RequestBody PhoneLineRequestDto phoneLineRequestDto) {
        return new ResponseEntity<>(phoneLineService.createPhoneLine(custId, phoneLineRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PhoneLineResponseDto>> getAllPhoneLines(@PathVariable Long custId) {
        return new ResponseEntity<>(phoneLineService.getAllPhoneLines(custId), HttpStatus.OK);
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<PhoneLineResponseDto> getPhoneLineById(@PathVariable String phoneNumber) {
        return new ResponseEntity<>(phoneLineService.getPhoneLineById(phoneNumber), HttpStatus.OK);
    }

    @PutMapping("/{phoneNumber}")
    public ResponseEntity<PhoneLineResponseDto> updatePhoneLine(@PathVariable String phoneNumber, @RequestBody PhoneLineRequestDto phoneLineRequestDto) {
        return new ResponseEntity<>(phoneLineService.updatePhoneLine(phoneNumber, phoneLineRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{phoneNumber}")
    public void deleteById  (@PathVariable String phoneNumber) {
        phoneLineService.deletePhoneLine(phoneNumber);
    }
}
 