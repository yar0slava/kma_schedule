package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.ClassroomDto;
import com.example.kma_schedule.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAddClassroomPage(){
        return "add-classroom";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClassroomDto classroomDto){
        classroomService.addNewClassroom(classroomDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ClassroomDto> getAll(){
        return  classroomService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClassroomDto get(@PathVariable Integer id){
        return  classroomService.getById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        classroomService.deleteById(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClassroomDto update(@RequestBody ClassroomDto classroomDto){
        return classroomService.update(classroomDto).get();
    }

}
