package com.nomorework.v1.db.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user")
@ToString
@Getter
public class User {

    public User(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String provider;
    private String providerId;
    private String jwsToken;

    private Boolean showHour;
    private Boolean showIncome;
    private Integer hourlyIncome;


    @Builder
    public User(Long id, String email, String provider, String providerId,
        String jwsToken, Boolean showHour, Boolean showIncome, Integer hourlyIncome){

        this.id = id;
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
        this.jwsToken = jwsToken;
        this.showHour = showHour;
        this.showIncome = showIncome;
        this.hourlyIncome = hourlyIncome;
    }

}
