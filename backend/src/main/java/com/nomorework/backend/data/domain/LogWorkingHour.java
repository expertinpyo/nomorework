package com.nomorework.backend.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="LogWorkingHour")
@ToString
@Getter
@NoArgsConstructor
public class LogWorkingHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private LocalDateTime nonWorkingTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Builder
    public LogWorkingHour(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime nonWorkingTime, User user){
        this.startTime = startTime;
        this.endTime = endTime;
        this.nonWorkingTime = nonWorkingTime;
        this.user = user;
    }
}
