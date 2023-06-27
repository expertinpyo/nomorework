package com.nomorework.backend.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.ToString;

@Entity
@Table(name="LogWorkingHour")
@ToString
public class LogWorkingHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private LocalDateTime nonWorkingTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
