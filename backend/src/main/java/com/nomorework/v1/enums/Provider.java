package com.nomorework.v1.enums;

public enum Provider {

    NAVER("NAVER"),
    GOOGLE("GOOGLE");

    private final String state;

    Provider(String state) { this.state = state;}

    public String state() {return state;}
}
