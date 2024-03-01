package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequestDto {

    private String name;
    private String address;
    private String email;
}