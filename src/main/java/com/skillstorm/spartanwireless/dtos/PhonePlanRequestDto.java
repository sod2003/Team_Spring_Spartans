package com.skillstorm.spartanwireless.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhonePlanRequestDto {

    @NotBlank(message = "Phone-Plan-Id cannot be blank.")
    private Long phonePlanId;
    @NotBlank(message = "Number of phone-lines cannot be blank.")
    private int phoneLines;
    @NotBlank(message = "Data limit cannot be blank.")
    private int dataLimit;
}
