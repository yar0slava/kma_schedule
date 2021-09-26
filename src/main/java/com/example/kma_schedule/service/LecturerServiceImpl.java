package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.database.repository.GroupRepository;
import com.example.kma_schedule.database.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> get() {
        return lecturerRepository.get();
    }

    @Override
    public Lecturer get(int id) {
        return lecturerRepository.get(id);
    }
}
