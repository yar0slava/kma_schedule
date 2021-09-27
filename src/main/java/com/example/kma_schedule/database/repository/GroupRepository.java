package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Integer> {
    List<Group> findByDegree(String degree);
    List<Group> findBySpecialization(String specialization);
}