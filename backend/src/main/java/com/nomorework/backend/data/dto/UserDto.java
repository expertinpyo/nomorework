package com.nomorework.backend.data.dto;

import com.nomorework.backend.data.domain.LogWorkingHour;
import java.util.List;

public class UserDto {

    public static class UserResponseDto {

        private Long id;

        private String provider;
        private String providerId;

        private Boolean showHour;
        private Boolean showIncome;

        private Integer hourlyIncome;
        private List<LogWorkingHour> logWorkingHours;
    }
}
