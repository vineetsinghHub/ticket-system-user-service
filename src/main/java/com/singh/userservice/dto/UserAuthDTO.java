package com.singh.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthDTO {

    @NotBlank(message = "Username is empty")
    private String username;
    @NotBlank(message = "Password is empty")
    private String password;
}
