package com.example.kma_schedule.controller;


import com.example.kma_schedule.service.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final RecordService recordService;
    private final DisciplineService disciplineService;
    private final LecturerService lecturerService;
    private final GroupService groupService;
    private final ClassroomService classroomService;
    private final ClassTimeService classTimeService;

    private MainController(
            RecordService recordService,
            DisciplineService disciplineService,
            LecturerService lecturerService,
            GroupService groupService,
            ClassroomService classroomService, ClassTimeService classTimeService) {
        this.recordService = recordService;
        this.disciplineService = disciplineService;
        this.lecturerService = lecturerService;
        this.groupService = groupService;
        this.classroomService = classroomService;
        this.classTimeService = classTimeService;
    }
}
