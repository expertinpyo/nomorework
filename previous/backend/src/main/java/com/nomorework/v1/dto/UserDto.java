package com.nomorework.v1.dto;

import lombok.Builder;
import lombok.ToString;

public class UserDto {

    @Builder
    @ToString
    public static class UserResponseDto {

        private Long id;

        private String email;

        private String provider;
        private String providerId;
        private String jwsToken;

        private Boolean showHour;
        private Boolean showIncome;
        private Integer hourlyIncome;
    }
}
