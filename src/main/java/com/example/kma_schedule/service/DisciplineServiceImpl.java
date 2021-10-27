package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.database.repository.DisciplineRepository;
import com.example.kma_schedule.dto.DisciplineDto;
import com.example.kma_schedule.mapper.DisciplineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private DisciplineMapper disciplineMapper;

    @Override
    public Optional<DisciplineDto> getById(Integer id) {
        Discipline discipline = disciplineRepository.findById(id).get();
        return Optional.of(disciplineMapper.toDto(discipline));
    }

    @Override
    public void addNewDiscipline(DisciplineDto disciplineDto) {
        Discipline discipline = disciplineMapper.toEntity(disciplineDto);
        disciplineRepository.save(discipline);
    }

    @Override
    public List<DisciplineDto> getAll() {
        return StreamSupport.stream(
                disciplineRepository.findAll().spliterator(), false )
                .map(disciplineMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public Optional<DisciplineDto> update(DisciplineDto disciplineDto) {
        Discipline discipline = disciplineRepository.save(disciplineMapper.toEntity(disciplineDto));
        return Optional.of(disciplineMapper.toDto(discipline));
    }
}