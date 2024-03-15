package com.skillstorm.spartanwireless.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequestDto {

    @NotBlank(message = "Customer's name cannot be blank.")
    private String name;
    @NotBlank(message = "Customer's address cannot be blank.")
    private String address;
    @Email
    @NotBlank(message = "Customer's email cannot be blank.")
    private String email;
}