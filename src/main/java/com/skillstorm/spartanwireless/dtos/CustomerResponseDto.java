package com.skillstorm.spartanwireless.dtos;

import java.util.List;

import com.skillstorm.spartanwireless.models.PhoneLine;
import com.skillstorm.spartanwireless.models.PhonePlan;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerResponseDto {

    private Long custId;
    private String name;
    private String address;
    private String email;
    private List<PhonePlan> phonePlans;
    private boolean isArchived;
    private List<PhoneLine> lines;
}