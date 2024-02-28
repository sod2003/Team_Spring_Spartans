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
@RequestMapping("/customers/{custId}/phone_plans")
public class PhonePlanController {
    
    @Autowired
    private PhonePlanService phonePlanService;

    @PostMapping("/{phonePlanId}")
    public ResponseEntity<PhonePlanResponseDto> createPhonePlan(@PathVariable Long custId, @PathVariable Long phonePlanId) {
        return new ResponseEntity<>(phonePlanService.createPhonePlan(custId, phonePlanId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PhonePlanResponseDto>> getAllPhonePlansByCustId(@PathVariable Long custId) {
        return new ResponseEntity<>(phonePlanService.getAllPhonePlansByCustId(custId), HttpStatus.OK);
    }

    @GetMapping("/{phonePlanId}")
    public ResponseEntity<PhonePlanResponseDto> getPhonePlanById(@PathVariable Long custId, @PathVariable Long phonePlanId) {
        return new ResponseEntity<>(phonePlanService.getPhonePlanById(custId, phonePlanId), HttpStatus.OK);
    }

    /*
    * The update method is obsolete because the phone plans are produced by Spartan Wireless,
    * and we are not providing custom phone plans at this moment in time.
    * The only updates made can be either creating or deleting a plan. 
    @PutMapping("/{phonePlanId}")
    public ResponseEntity<PhonePlanResponseDto> updatePhonePlan(@PathVariable Long phonePlanId, @RequestBody PhonePlanRequestDto phonePlanRequestDto) {
        return new ResponseEntity<>(phonePlanService.updatePhonePlan(phonePlanId, phonePlanRequestDto), HttpStatus.OK);
    }
    */

    @DeleteMapping("/{phonePlanId}")
    public void deletePhonePlan(@PathVariable Long custId, @PathVariable Long phonePlanId) {
        phonePlanService.deletePhonePlan(custId, phonePlanId);
    }
}
