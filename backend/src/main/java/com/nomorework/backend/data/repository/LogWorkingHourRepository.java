package com.nomorework.backend.data.repository;

import com.nomorework.backend.data.domain.LogWorkingHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogWorkingHourRepository extends JpaRepository<LogWorkingHour, Long> {

}
