package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Classroom;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {
    Optional<Classroom> findByName(String name);
}
