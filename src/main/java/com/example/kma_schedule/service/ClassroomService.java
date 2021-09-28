package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Classroom;
import java.util.List;
import java.util.Optional;

public interface ClassroomService {
    Optional<Classroom> getById(Integer id);
    Optional<Classroom> getByName(String name);
    void addNewClassroom(Classroom classroom);
    List<Classroom> getAll();

}
