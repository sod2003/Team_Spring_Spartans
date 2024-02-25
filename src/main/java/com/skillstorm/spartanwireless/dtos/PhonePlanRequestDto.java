package com.skillstorm.spartanwireless.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhonePlanRequestDto {

    private int phoneLines;
    private int dataLimit;
}
