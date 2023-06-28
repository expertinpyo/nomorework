package com.nomorework.v1.web.service.impl;

import com.nomorework.v1.db.repository.UserRepository;
import com.nomorework.v1.dto.UserDto.UserResponseDto;
import com.nomorework.v1.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUser(String email) {
        //UserResponseDto.builder(1);
        return null;
    }
}
