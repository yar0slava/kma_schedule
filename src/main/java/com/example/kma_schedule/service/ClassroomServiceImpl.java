package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Classroom;
import com.example.kma_schedule.database.repository.ClassroomRepository;
import com.example.kma_schedule.dto.ClassroomDto;
import com.example.kma_schedule.mapper.ClassroomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public Optional<ClassroomDto> getById(Integer id) {
        return Optional.of(classroomMapper.toDto(classroomRepository.findById(id).get()));
    }

    @Override
    public Optional<ClassroomDto> getByName(String name) {
        return Optional.of(classroomMapper.toDto(classroomRepository.findByName(name).get()));
    }

    @Override
    public void addNewClassroom(ClassroomDto classroom) {
        Classroom classroomEntity = classroomMapper.toEntity(classroom);
        classroomRepository.save(classroomEntity);
    }

    @Override
    public List<ClassroomDto> getAll() {
        return StreamSupport.stream(
                        classroomRepository.findAll().spliterator(), false )
                .map(classroomMapper::toDto)
                .collect(Collectors.toList());    }

    @Override
    public void deleteById(Integer id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Optional<ClassroomDto> update(ClassroomDto classroom) {
        return Optional.of(classroomMapper.toDto(classroomRepository.save(classroomMapper.toEntity(classroom))));
    }
}