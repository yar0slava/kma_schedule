package com.example.kma_schedule.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassroomDto {

    private String name;
    private Integer capacity;

    //for 5th task, added this field
    //in future - admin will be pulled out from the Context
    private String adminLogin;
}
