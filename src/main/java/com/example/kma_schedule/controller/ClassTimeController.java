package com.example.kma_schedule.controller;

import com.example.kma_schedule.database.entity.WeekDay;
import com.example.kma_schedule.dto.ClassTimeDto;
import com.example.kma_schedule.service.ClassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classtime")
public class ClassTimeController {

    @Autowired
    private ClassTimeService classTimeService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAddClasstimePage() {
        return "add-classtime";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClassTimeDto classTimeDto) {
        classTimeService.addNewClassTime(classTimeDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ClassTimeDto> getAll() {
        return classTimeService.getAll();
    }

    @GetMapping("/{weekDay}/{weekNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ClassTimeDto> getByWeekDayAndWeekNumber(@PathVariable WeekDay weekDay, @PathVariable Integer weekNumber) {
        return classTimeService.getByWeekDayAndWeekNumber(weekDay, weekNumber);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClassTimeDto get(@PathVariable Integer id) {
        return classTimeService.getById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        classTimeService.deleteById(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClassTimeDto update(@RequestBody ClassTimeDto classTimeDto) {
        return classTimeService.update(classTimeDto).get();
    }
}
