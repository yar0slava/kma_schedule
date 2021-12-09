package com.example.kma_schedule.dto;

import com.example.kma_schedule.database.entity.WeekDay;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class FullRecordDto {

    private Integer id;
    private Integer disciplineId;
    private String disciplineName;

    private Integer classTimeId;
    private WeekDay weekDay;
    private LocalTime classTime;
    private Integer weekNumber;

    private Integer groupId;
    private Integer groupNumber;

    private Integer classroomId;
    private String classroomName;

    private Integer lecturerId;
    private String lecturerName;
    private String lecturerSurname;
    private String lecturerMiddlename;
}
