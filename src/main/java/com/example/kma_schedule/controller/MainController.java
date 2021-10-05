package com.example.kma_schedule.controller;


import com.example.kma_schedule.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final RecordServiceImpl recordService;
    private final DisciplineServiceImpl disciplineService;
    private final LecturerServiceImpl lecturerService;
    private final GroupServiceImpl groupService;
    private final ClassroomServiceImpl classroomService;
    private final ClassTimeServiceImpl classTimeService;

    private MainController(
            RecordServiceImpl recordService,
            DisciplineServiceImpl disciplineService,
            LecturerServiceImpl lecturerService,
            GroupServiceImpl groupService,
            ClassroomServiceImpl classroomService, ClassTimeServiceImpl classTimeService) {
        this.recordService = recordService;
        this.disciplineService = disciplineService;
        this.lecturerService = lecturerService;
        this.groupService = groupService;
        this.classroomService = classroomService;
        this.classTimeService = classTimeService;
    }
}