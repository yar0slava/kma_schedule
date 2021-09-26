package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Lecturer;

import java.util.List;

public interface LecturerRepository {
    List<Lecturer> get();
    Lecturer get(int id);
}
