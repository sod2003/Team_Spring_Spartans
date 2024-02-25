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

import com.skillstorm.spartanwireless.dtos.PhonePlanRequestDto;
import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;
import com.skillstorm.spartanwireless.services.PhonePlanService;

@RestController
@RequestMapping("/phone_plans")
public class PhonePlanController {
    
    @Autowired
    private PhonePlanService phonePlanService;

    @PostMapping
    public ResponseEntity<PhonePlanResponseDto> createPhonePlan(@RequestBody PhonePlanRequestDto phonePlanRequestDto) {
        return new ResponseEntity<>(phonePlanService.createPhonePlan(phonePlanRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PhonePlanResponseDto>> getAllPhonePlans() {
        return new ResponseEntity<>(phonePlanService.getAllPhonePlans(), HttpStatus.OK);
    }

    @GetMapping("/{phonePlanId}")
    public ResponseEntity<PhonePlanResponseDto> getPhonePlanById(@PathVariable Long phonePlanId) {
        return new ResponseEntity<>(phonePlanService.getPhonePlanById(phonePlanId), HttpStatus.OK);
    }

    @PutMapping("/{phonePlanId}")
    public ResponseEntity<PhonePlanResponseDto> updatePhonePlan(@PathVariable Long phonePlanId, @RequestBody PhonePlanRequestDto phonePlanRequestDto) {
        return new ResponseEntity<>(phonePlanService.updatePhonePlan(phonePlanId, phonePlanRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{phonePlanId}")
    public void deletePhonePlan(@PathVariable Long phonePlanId) {
        phonePlanService.deletePhonePlan(phonePlanId);
    }
}
