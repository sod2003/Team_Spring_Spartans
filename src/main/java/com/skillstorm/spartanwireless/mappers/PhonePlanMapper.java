package com.skillstorm.spartanwireless.mappers;

import com.skillstorm.spartanwireless.dtos.PhonePlanRequestDto;
import com.skillstorm.spartanwireless.dtos.PhonePlanResponseDto;
import com.skillstorm.spartanwireless.models.PhonePlan;

public class PhonePlanMapper {
    
    public static PhonePlan mapToPhonePlan(PhonePlanRequestDto phonePlanRequestDto) {
        return PhonePlan
            .builder()
            .phonePlanId(phonePlanRequestDto.getPhonePlanId())
            .phoneLines(phonePlanRequestDto.getPhoneLines())
            .dataLimit(phonePlanRequestDto.getDataLimit())
            .build();
    }

    public static PhonePlanResponseDto mapToPhonePlanResponseDto(PhonePlan phonePlan) {
        return PhonePlanResponseDto
            .builder()
            .phonePlanId(phonePlan.getPhonePlanId())
            .phoneLines(phonePlan.getPhoneLines())
            .dataLimit(phonePlan.getDataLimit())
            .cost(phonePlan.getCost())
            .customers(phonePlan.getCustomers())
            .build();
    }
}
