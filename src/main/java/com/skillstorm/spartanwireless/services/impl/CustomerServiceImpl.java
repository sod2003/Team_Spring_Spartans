package com.skillstorm.spartanwireless.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spartanwireless.dtos.LoginRequestDto;
import com.skillstorm.spartanwireless.dtos.LoginResponseDto;
import com.skillstorm.spartanwireless.dtos.RegisterRequestDto;
import com.skillstorm.spartanwireless.dtos.RegisterResponseDto;
import com.skillstorm.spartanwireless.repositories.CustomerRepository;
import com.skillstorm.spartanwireless.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {
        return customerRepository.save(registerRequestDto);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return loginRepository.save(loginRequestDto);
    }
    
}
