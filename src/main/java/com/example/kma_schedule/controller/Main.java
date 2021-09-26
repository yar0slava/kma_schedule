package com.example.kma_schedule.controller;

import com.example.kma_schedule.service.RecordService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    private final RecordService recordService;

    public Main(RecordService recordService) {
        this.recordService = recordService;
    }
}
