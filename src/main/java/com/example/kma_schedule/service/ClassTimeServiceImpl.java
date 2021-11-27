package com.example.kma_schedule.service;

import com.example.kma_schedule.database.repository.ClassTimeRepository;
import com.example.kma_schedule.dto.ClassTimeDto;
import com.example.kma_schedule.mapper.ClassTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClassTimeServiceImpl implements ClassTimeService {

    @Autowired
    private ClassTimeRepository classTimeRepository;
    @Autowired
    private ClassTimeMapper classTimeMapper;

    @Override
    public Optional<ClassTimeDto> getById(Integer id) {
        return Optional.of(classTimeMapper.toDto(classTimeRepository.findById(id).get()));
    }

    @Override
    public void addNewClassTime(ClassTimeDto classTime) {
        classTimeRepository.save(classTimeMapper.toEntity(classTime));
    }

    @Override
    public List<ClassTimeDto> getAll() {
        return StreamSupport.stream(
                        classTimeRepository.findAll().spliterator(), false )
                .map(classTimeMapper::toDto)
                .collect(Collectors.toList());    }

    @Override
    public void deleteById(Integer id) {
        classTimeRepository.deleteById(id);
    }

    @Override
    public Optional<ClassTimeDto> update(ClassTimeDto classTime) {
        return Optional.of(classTimeMapper.toDto(classTimeRepository.save(classTimeMapper.toEntity(classTime))));
    }
}