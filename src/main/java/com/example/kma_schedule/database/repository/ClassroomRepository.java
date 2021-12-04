package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findByNameContains(String name);
}
