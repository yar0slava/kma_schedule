package com.example.kma_schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordDto {

    private Integer id;
    private Integer disciplineId;
    private Integer classTimeId;
    private String groupId;
    private Integer classroomId;
    private Integer lecturerId;
}
