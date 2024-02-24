package com.skillstorm.spartanwireless.services;

import com.skillstorm.spartanwireless.dtos.LoginRequestDto;
import com.skillstorm.spartanwireless.dtos.LoginResponseDto;
import com.skillstorm.spartanwireless.dtos.RegisterRequestDto;
import com.skillstorm.spartanwireless.dtos.RegisterResponseDto;

public interface CustomerService {

    RegisterResponseDto register(RegisterRequestDto registerRequestDto);
    LoginResponseDto login(LoginRequestDto loginRequestDto);
    
}
