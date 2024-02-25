package com.skillstorm.spartanwireless.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.PhonePlanRequestDto;
import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;
import com.skillstorm.spartanwireless.models.PhonePlan;
import com.skillstorm.spartanwireless.repositories.PhonePlanRepository;
import com.skillstorm.spartanwireless.services.PhonePlanService;

import static com.skillstorm.spartanwireless.mappers.PhonePlanMapper.mapToPhonePlan;
import static com.skillstorm.spartanwireless.mappers.PhonePlanMapper.mapToPhonePlanResponseDto;

@Service
public class PhonePlanServiceImpl implements PhonePlanService {

    @Autowired
    private PhonePlanRepository phonePlanRepository;

    @Override
    public PhonePlanResponseDto createPhonePlan(PhonePlanRequestDto phonePlanRequestDto) {
        return mapToPhonePlanResponseDto(phonePlanRepository.save(mapToPhonePlan(phonePlanRequestDto)));
    }

    @Override
    public List<PhonePlanResponseDto> getAllPhonePlans() {
        return phonePlanRepository.findAll().stream().map((phonePlan) -> mapToPhonePlanResponseDto(phonePlan)).collect(Collectors.toList());
    }

    @Override
    public PhonePlanResponseDto getPhonePlanById(Long phonePlanId) {
        return mapToPhonePlanResponseDto(phonePlanRepository.findById(phonePlanId).get());
    }

    @Override
    public PhonePlanResponseDto updatePhonePlan(Long phonePlanId, PhonePlanRequestDto phonePlanRequestDto) {
        PhonePlan phonePlan = mapToPhonePlan(phonePlanRequestDto);
        phonePlan.setPhonePlanId(phonePlanId);
        return mapToPhonePlanResponseDto(phonePlanRepository.save(phonePlan));
    }

    @Override
    public void deletePhonePlan(Long phonePlanId) {
        phonePlanRepository.deleteById(phonePlanId);
    }
    
}
