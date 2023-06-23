package com.nomorework.v1.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("")
    public String getUser(){
        String msg;
        msg = "Love you Bora";
        return msg;
    }
}