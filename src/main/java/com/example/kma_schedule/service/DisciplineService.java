package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.dto.DisciplineDto;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Optional<Discipline> getById(Integer id);
    void addNewDiscipline(DisciplineDto discipline);
    List<Discipline> getAll();
    void deleteById(Integer id);
    Optional<Discipline> update(DisciplineDto discipline);
}
