package com.example.kma_schedule.service;

import com.example.kma_schedule.dto.ClassroomDto;

import java.util.List;
import java.util.Optional;

public interface ClassroomService {
    Optional<ClassroomDto> getById(Integer id);
    List<ClassroomDto> getByName(String name);
    void addNewClassroom(ClassroomDto classroom);
    List<ClassroomDto> getAll();
    void deleteById(Integer id);
    Optional<ClassroomDto> update(ClassroomDto classroom);
}
