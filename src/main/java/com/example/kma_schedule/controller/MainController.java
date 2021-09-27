package com.example.kma_schedule.controller;

import com.example.kma_schedule.service.DisciplineService;
import com.example.kma_schedule.service.RecordService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final RecordService recordService;
    private final DisciplineService disciplineService;

    private MainController(
            RecordService recordService,
            DisciplineService disciplineService
    ) {
        this.recordService = recordService;
        this.disciplineService = disciplineService;
    }
}
