package com.example.kma_schedule.controller;

import com.example.kma_schedule.dto.LecturerDto;
import com.example.kma_schedule.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lectors")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAddLectorPage(){
            return "add-lecturer";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<LecturerDto> getAll(){
        return  lecturerService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public LecturerDto get(@PathVariable Integer id){
        return  lecturerService.getById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        lecturerService.deleteById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LecturerDto lecturer){
        lecturerService.addNewLecturer(lecturer);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public LecturerDto update(@RequestBody LecturerDto lecturer){
        return lecturerService.update(lecturer).get();
    }
}
