package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.database.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

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

    @Override
    public void deleteById(Integer id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public Optional<Discipline> update(Discipline discipline) {
        return Optional.of(disciplineRepository.save(discipline));
    }
}