package com.nomorework.v1.db.domain;


import com.nomorework.v1.enums.Provider;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name="user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String token;
    private Provider provider;

    private Boolean showHour;
    private Boolean showIncome;
    private Integer hourlyIncome;

}
