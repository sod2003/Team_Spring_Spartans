package com.skillstorm.spartanwireless.services;

import java.util.List;

import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;

public interface PhonePlanService {
    
    PhonePlanResponseDto createPhonePlan(Long custId, Long phonePlanId);
    List<PhonePlanResponseDto> getAllPhonePlansByCustId(Long custId);
    PhonePlanResponseDto getPhonePlanById(Long custId, Long phonePlanId);
    //(comment in controller) PhonePlanResponseDto updatePhonePlan(Long phonePlandId, PhonePlanRequestDto phonePlanRequestDto);
    void deletePhonePlan(Long custId, Long phonePlanId);
}
