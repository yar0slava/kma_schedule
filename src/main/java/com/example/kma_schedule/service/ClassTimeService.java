package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.WeekDay;
import com.example.kma_schedule.dto.ClassTimeDto;

import java.util.List;
import java.util.Optional;

public interface ClassTimeService {
    Optional<ClassTimeDto> getById(Integer id);
    void addNewClassTime(ClassTimeDto classTime);
    List<ClassTimeDto> getAll();
    void deleteById(Integer id);
    Optional<ClassTimeDto> update(ClassTimeDto classTime);

    List<ClassTimeDto> getByWeekDayAndWeekNumber(WeekDay weekDay, Integer weekNumber);
}
