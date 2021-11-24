package com.example.kma_schedule.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ClassTimeDto {

    private LocalDate classDate;
    private LocalTime classTime;
    private Integer weekNumber;
}
