package com.skillstorm.spartanwireless.dtos;

import java.util.List;

import com.skillstorm.spartanwireless.models.Customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhonePlanResponseDto {

    private Long phonePlanId;
    private int phoneLines;
    private int dataLimit;
    private double cost;
    private List<Customer> customers;
}
