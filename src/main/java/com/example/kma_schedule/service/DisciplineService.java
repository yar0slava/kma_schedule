package com.example.kma_schedule.service;

import com.example.kma_schedule.dto.DisciplineDto;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Optional<DisciplineDto> getById(Integer id);
    void addNewDiscipline(DisciplineDto discipline);
    List<DisciplineDto> getAll();
    void deleteById(Integer id);
    Optional<DisciplineDto> update(DisciplineDto discipline);
}
