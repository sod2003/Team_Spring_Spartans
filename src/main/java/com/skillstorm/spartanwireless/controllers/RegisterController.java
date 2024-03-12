package com.skillstorm.spartanwireless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spartanwireless.dtos.CustomerRequestDto;
import com.skillstorm.spartanwireless.dtos.CustomerResponseDto;
import com.skillstorm.spartanwireless.dtos.RegisterRequestDto;
import com.skillstorm.spartanwireless.models.UserEntity;
import com.skillstorm.spartanwireless.repositories.UserRepository;

import static com.skillstorm.spartanwireless.mappers.CustomerMapper.mapToCustomer;

@CrossOrigin("http://localhost:4200")
@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
        if (userRepository.existsById(registerRequestDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        CustomerRequestDto customerRequestDto = CustomerRequestDto
            .builder()
            .name(registerRequestDto.getFullName())
            .email(registerRequestDto.getEmail())
            .address(registerRequestDto.getAddress())
            .build();

        /*
        There is a save and persistance to database here too. 
        Based on our Entity Relationship (ER), it is necessary
        to call the customer controller and persist the request of
        the customer based on the request from the register which
        contains information for both user and customer. Out of all
        different options, this is the best solution.
        */
        CustomerResponseDto customerResponseDto = customerController.createCustomer(customerRequestDto);

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequestDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode((registerRequestDto.getPassword())));
        userEntity.setCustomer(mapToCustomer(customerResponseDto));

        userRepository.save(userEntity);

        return new ResponseEntity<>("User registered!", HttpStatus.CREATED);
    }
}