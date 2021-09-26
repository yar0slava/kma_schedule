package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Lecturer;

import java.util.List;

public interface LecturerService {
    List<Lecturer> get();
    Lecturer get(int id);
}
