package com.singh.userservice.controller;

import com.singh.userservice.dto.UserAuthDTO;
import com.singh.userservice.dto.UserDTO;
import com.singh.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public UserDTO login(@RequestBody @Valid UserAuthDTO user){
        return userService.login(user);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody @Valid UserDTO user){
        return userService.register(user);
    }

}
