package com.nomorework.v1.db.domain;

import com.nomorework.v1.enums.Day;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="LogWorkingHour")
@ToString
@Getter
public class LogWorkingHour {

    public LogWorkingHour(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;

    private  LocalDateTime endTime;

    @Enumerated(EnumType.STRING) // Enum String으로 사용하겠다!
    private Day day;

    private LocalDateTime nonWorkingTime;

    @Builder
    public LogWorkingHour(Long id, LocalDateTime startTime, LocalDateTime endTime, Day day, LocalDateTime nonWorkingTime){
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.nonWorkingTime = nonWorkingTime;
    }
}
