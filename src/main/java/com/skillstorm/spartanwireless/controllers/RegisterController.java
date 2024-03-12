package com.skillstorm.spartanwireless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spartanwireless.dtos.RegisterRequestDto;
import com.skillstorm.spartanwireless.models.UserEntity;
import com.skillstorm.spartanwireless.repositories.UserRepository;

@CrossOrigin
@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
        if (userRepository.existsById(registerRequestDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerRequestDto.getPassword())));


        userRepository.save(user);

        return new ResponseEntity<>("User registered!", HttpStatus.OK);
    }
}