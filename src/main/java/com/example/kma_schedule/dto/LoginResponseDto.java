package com.example.kma_schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto {
    String token;

    @Override
    public String toString() {
        return "{" +
                "\"token\":\"" + token + '\"' +
                '}';
    }
}
