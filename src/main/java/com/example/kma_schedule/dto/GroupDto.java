package com.example.kma_schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDto {

    private Integer id;
    private Boolean isLecture;
    private String specialization;
    private String degree;
    private Integer course;
    private Integer groupNumber;
    private Integer lecturerId;

}
