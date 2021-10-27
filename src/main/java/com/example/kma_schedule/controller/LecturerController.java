package com.example.kma_schedule.controller;

import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectors")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Lecturer> getAll(){
        return lecturerService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Lecturer get(@PathVariable Integer id){
        return  lecturerService.getById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        lecturerService.deleteById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Lecturer lecturer){
        lecturerService.addNewLecturer(lecturer);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Lecturer lecturer){
        lecturerService.update(lecturer);
    }
}
