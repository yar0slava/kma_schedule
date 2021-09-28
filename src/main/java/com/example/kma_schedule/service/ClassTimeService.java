package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.ClassTime;
import java.util.List;
import java.util.Optional;

public interface ClassTimeService {
    Optional<ClassTime> getById(Integer id);
    void addNewClassTime(ClassTime classTime);
    List<ClassTime> getAll();
}
