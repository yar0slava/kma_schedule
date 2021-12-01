package com.example.kma_schedule.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LecturerDto {

    private Integer lecturerId;
    private String name;
    private String surname;
    private String middlename;
}
