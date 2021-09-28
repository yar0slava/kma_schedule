package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Lecturer;

import java.util.List;
import java.util.Optional;

public interface LecturerService {
    List<Lecturer> getAll();
    Optional<Lecturer> getById(int id);
    void addNewLecturer(Lecturer lecturer);
}
