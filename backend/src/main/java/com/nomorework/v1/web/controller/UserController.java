package com.nomorework.v1.web.controller;

import com.nomorework.v1.db.domain.User;
import com.nomorework.v1.dto.UserDto.UserResponseDto;
import com.nomorework.v1.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/test")
    public String test(){

        User userTest = User.builder()
            .email("test")
            .build();

        return userTest.toString();
    }
}
