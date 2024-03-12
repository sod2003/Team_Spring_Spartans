package com.skillstorm.spartanwireless.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequestDto {

    private String fullName;
    private String email;
    private String address;
    private String username;
    private String password;
    
}
