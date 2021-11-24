package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.ClassroomDto;
import com.example.kma_schedule.dto.LecturerDto;
import com.example.kma_schedule.service.ClassroomService;
import com.example.kma_schedule.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAddLectorPage(){
        return "add-classroom";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClassroomDto classroomDto){
        classroomService.addNewClassroom(classroomDto);
    }
}
