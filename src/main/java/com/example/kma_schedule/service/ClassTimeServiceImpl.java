package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.ClassTime;
import com.example.kma_schedule.database.repository.ClassTimeRepository;
import com.example.kma_schedule.dto.ClassTimeDto;
import com.example.kma_schedule.mapper.ClassTimeMapper;
import com.example.kma_schedule.mapper.LecturerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassTimeServiceImpl implements ClassTimeService {

    @Autowired
    private ClassTimeRepository classTimeRepository;
    @Autowired
    private ClassTimeMapper classTimeMapper;

    @Override
    public Optional<ClassTime> getById(Integer id) {
        return classTimeRepository.findById(id);
    }

    @Override
    public void addNewClassTime(ClassTimeDto classTime) {
        classTimeRepository.save(classTimeMapper.toEntity(classTime));
    }

    @Override
    public List<ClassTime> getAll() {
        return (List<ClassTime>) classTimeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classTimeRepository.deleteById(id);
    }

    @Override
    public Optional<ClassTime> update(ClassTime classTime) {
        return Optional.of(classTimeRepository.save(classTime));
    }

}