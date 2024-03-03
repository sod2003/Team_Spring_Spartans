package com.skillstorm.spartanwireless.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;
import com.skillstorm.spartanwireless.models.PhonePlan;
import com.skillstorm.spartanwireless.repositories.PhonePlanRepository;

@ExtendWith(MockitoExtension.class)
public class TestPhonePlanServiceImpl {

    @Mock
    private PhonePlanRepository phonePlanRepository;

    @InjectMocks
    private PhonePlanServiceImpl phonePlanServiceImpl;

    @Autowired
    private Long phonePlanId;

    @Autowired
    private PhonePlan phonePlan1;

    @Autowired
    private PhonePlan phonePlan2;

    @BeforeEach
    public void init() {
        phonePlanId = 1L;
        phonePlan1 = PhonePlan.builder().phonePlanId(1L).phoneLines(3).dataLimit(10).build();
        phonePlan2 = PhonePlan.builder().phonePlanId(2L).phoneLines(1).dataLimit(5).build();
    }

    @Test
    public void PhonePlanService_GetAllPhonePlans_ReturnsListOfPhonePlanResponseDto() {
        List<PhonePlan> phonePlans = new ArrayList<>();
        phonePlans.add(phonePlan1);
        phonePlans.add(phonePlan2);
        when(phonePlanRepository.findAll()).thenReturn(phonePlans);
        List<PhonePlanResponseDto> phonePlanResponseDtos = phonePlanServiceImpl.getAllPhonePlans();
        assertNotNull(phonePlanResponseDtos);
    }

    @Test
    public void PhonePlanService_GetPhonePlanById_ReturnsPhonePlanResponseDto() {
        when(phonePlanRepository.findById(phonePlanId)).thenReturn(Optional.ofNullable(phonePlan1));
        PhonePlanResponseDto phonePlanResponseDto = phonePlanServiceImpl.getPhonePlanById(phonePlanId);
        assertNotNull(phonePlanResponseDto);
    }
    
}
