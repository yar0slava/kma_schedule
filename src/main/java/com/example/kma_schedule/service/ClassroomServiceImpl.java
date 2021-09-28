package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Classroom;
import com.example.kma_schedule.database.repository.ClassroomRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

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
}
