package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.dto.GroupDto;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> getAll();
    Optional<Group> getById(String id);
    void addNewGroup(GroupDto group);
    List<Group> findByDegree(String degree);
    List<Group> findBySpecialization(String specialization);
    void deleteById(String id);
    Optional<Group> update(Group group);
}
