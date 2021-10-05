package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.database.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public Optional<Discipline> getById(Integer id) {
        return disciplineRepository.findById(id);
    }

    @Override
    public void addNewDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    @Override
    public List<Discipline> getAll() {
        return (List<Discipline>) disciplineRepository.findAll();
    }
}