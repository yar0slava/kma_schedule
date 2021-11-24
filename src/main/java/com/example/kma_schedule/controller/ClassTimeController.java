package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.ClassTimeDto;
import com.example.kma_schedule.dto.ClassroomDto;
import com.example.kma_schedule.service.ClassTimeService;
import com.example.kma_schedule.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classtime")
public class ClassTimeController {

    @Autowired
    private ClassTimeService classTimeService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAddLectorPage(){
        return "add-classtime";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClassTimeDto classTimeDto){
        classTimeService.addNewClassTime(classTimeDto);
    }

}
