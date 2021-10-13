package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.database.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> getAll() {
        return (List<Lecturer>) lecturerRepository.findAll();
    }

    @Override
    public Optional<Lecturer> getById(Integer id) {
        return lecturerRepository.findById(id);
    }

    @Override
    public void addNewLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteById(Integer id) {
        lecturerRepository.deleteById(id);
    }

    @Override
    public Optional<Lecturer> update(Lecturer lecturer) {
        return Optional.of(lecturerRepository.save(lecturer));
    }
}