package com.skillstorm.spartanwireless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spartanwireless.dtos.LoginRequestDto;
import com.skillstorm.spartanwireless.dtos.LoginResponseDto;
import com.skillstorm.spartanwireless.repositories.UserRepository;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
                .unauthenticated(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);
        Long custId = userRepository.findById(loginRequestDto.getUsername()).get().getCustomer().getCustId();
        return new ResponseEntity<>(new LoginResponseDto(loginRequestDto.getUsername(), custId), HttpStatus.OK);
    }
}