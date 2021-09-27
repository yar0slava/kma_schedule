package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Optional<Discipline> get(Integer id);

    List<Discipline> getAll();
}
