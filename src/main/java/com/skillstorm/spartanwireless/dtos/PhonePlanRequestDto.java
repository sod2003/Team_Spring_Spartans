package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhonePlanRequestDto {

    private Long phonePlanId;
    private int phoneLines;
    private int dataLimit;
}
