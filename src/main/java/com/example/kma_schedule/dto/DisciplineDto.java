package com.example.kma_schedule.dto;

import com.example.kma_schedule.database.entity.Lecturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineDto {

    private Integer disciplineId;
    private String name;
    private Lecturer lecturer;
}
