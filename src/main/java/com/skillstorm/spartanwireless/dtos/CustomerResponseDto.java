package com.skillstorm.spartanwireless.dtos;

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
}