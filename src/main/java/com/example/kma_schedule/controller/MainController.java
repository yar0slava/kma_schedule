package com.example.kma_schedule.controller;

import com.example.kma_schedule.service.DisciplineService;
import com.example.kma_schedule.service.GroupService;
import com.example.kma_schedule.service.LecturerService;
import com.example.kma_schedule.service.RecordService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final RecordService recordService;
    private final DisciplineService disciplineService;
    private final LecturerService lecturerService;
    private final GroupService groupService;

    private MainController(
            RecordService recordService,
            DisciplineService disciplineService,
            LecturerService lecturerService,
            GroupService groupService
    ) {
        this.recordService = recordService;
        this.disciplineService = disciplineService;
        this.lecturerService = lecturerService;
        this.groupService = groupService;
    }
}
