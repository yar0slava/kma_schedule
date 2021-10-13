package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, String> {
    List<Group> findByDegree(String degree);
    List<Group> findBySpecialization(String specialization);
}