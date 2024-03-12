package com.skillstorm.spartanwireless.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class LoginResponseDto {

    private String username;
    private Long custId;
    
}
