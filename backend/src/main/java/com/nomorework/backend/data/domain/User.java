package com.nomorework.backend.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.ToString;

@Entity
@Table(name = "user")
@ToString
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provider;
    private String providerId;

    private Boolean showHour;
    private Boolean showIncome;

    private Integer hourlyIncome;

    @OneToMany(mappedBy = "user")
    private List<LogWorkingHour> logWorkingHours;

}
