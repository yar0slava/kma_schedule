package com.example.kma_schedule.dto;

import com.example.kma_schedule.database.entity.WeekDay;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
public class ClassTimeDto {

    private Integer classTimeId;
    private WeekDay weekDay;
    private LocalTime classTime;
    private Integer weekNumber;
}
