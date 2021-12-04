package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findByDegree(String degree);

    List<Group> findBySpecialization(String specialization);

    List<Group> findBySpecializationAndCourse(String specialization, Integer course);
}