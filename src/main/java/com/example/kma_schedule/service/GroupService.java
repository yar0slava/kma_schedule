package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> get();
    Group get(String id);
    List<Group> findByDegree(String degree);
    List<Group> findBySpecialization(String specialization);
}
