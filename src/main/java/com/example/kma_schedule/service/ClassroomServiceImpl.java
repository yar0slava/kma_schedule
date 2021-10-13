package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Classroom;
import com.example.kma_schedule.database.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Optional<Classroom> getById(Integer id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Optional<Classroom> getByName(String name) {
        return classroomRepository.findByName(name);
    }

    @Override
    public void addNewClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAll() {
        return (List<Classroom>) classroomRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Optional<Classroom> update(Classroom classroom) {
        return Optional.of(classroomRepository.save(classroom));
    }
}