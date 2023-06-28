package com.nomorework.v1.db.repository;

import com.nomorework.v1.db.domain.LogWorkingHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogWorkingHourRepository extends JpaRepository<LogWorkingHour, Long> {

}
