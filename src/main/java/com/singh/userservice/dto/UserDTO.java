package com.singh.userservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Username is empty")
    private String username;
    @NotBlank(message = "Password is empty")
    private String password;
    @NotBlank(message = "Firstname is empty")
    private String firstName;
    @NotBlank(message = "Lastname is empty")
    private String lastName;
    @NotBlank(message = "Email is empty")
    private String email;
    @NotBlank(message = "Phone is empty")
    private String phone;
}
