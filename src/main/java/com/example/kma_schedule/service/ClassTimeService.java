package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.ClassTime;
import com.example.kma_schedule.dto.ClassTimeDto;

import java.util.List;
import java.util.Optional;

public interface ClassTimeService {
    Optional<ClassTime> getById(Integer id);
    void addNewClassTime(ClassTimeDto classTime);
    List<ClassTime> getAll();
    void deleteById(Integer id);
    Optional<ClassTime> update(ClassTime classTime);
}
