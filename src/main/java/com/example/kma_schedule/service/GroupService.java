package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.dto.GroupDto;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<GroupDto> getAll();
    Optional<GroupDto> getById(Integer id);
    void addNewGroup(GroupDto group);
    List<GroupDto> findByDegree(String degree);
    List<GroupDto> findBySpecialization(String specialization);
    List<GroupDto> getBySpecializationAndCourse(String specialization, Integer course);
    void deleteById(Integer id);
    Optional<GroupDto> update(GroupDto group);
}
