package com.skillstorm.spartanwireless.services;

import java.util.List;

import com.skillstorm.spartanwireless.dtos.PhonePlanRequestDto;
import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;

public interface PhonePlanService {
    
    PhonePlanResponseDto createPhonePlan(PhonePlanRequestDto phonePlanRequestDto);
    List<PhonePlanResponseDto> getAllPhonePlans();
    PhonePlanResponseDto getPhonePlanById(Long phonePlanId);
    PhonePlanResponseDto updatePhonePlan(Long phonePlandId, PhonePlanRequestDto phonePlanRequestDto);
    void deletePhonePlan(Long phonePlanId);
}
