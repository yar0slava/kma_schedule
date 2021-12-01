package com.example.kma_schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    String email;
    String password;

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
