package com.nomorework.v1.web.service;

import com.nomorework.v1.dto.UserDto.UserResponseDto;

public interface UserService {

    UserResponseDto getUser(String email);
}
