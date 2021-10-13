package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Optional<Discipline> getById(Integer id);
    void addNewDiscipline(Discipline discipline);
    List<Discipline> getAll();
    void deleteById(Integer id);
    Optional<Discipline> update(Discipline discipline);
}
