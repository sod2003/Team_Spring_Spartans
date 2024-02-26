package com.skillstorm.spartanwireless.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhonePlanRequestDto {

    private Long phonePlanId;
    private int phoneLines;
    private int dataLimit;
}
