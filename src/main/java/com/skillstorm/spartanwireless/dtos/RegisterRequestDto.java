package com.skillstorm.spartanwireless.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequestDto {

    @NotBlank(message = "Name cannot be blank.")
    private String fullName;
    @Email
    @NotBlank(message = "Email cannot be blank.")
    private String email;
    @NotBlank(message = "Address cannot be blank.")
    private String address;
    @NotBlank(message = "Username cannot be blank.")
    private String username;
    @NotBlank(message = "Password cannot be blank.")
    private String password;
    
}
