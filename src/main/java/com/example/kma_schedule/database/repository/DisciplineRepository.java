package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {

    List<Discipline> findByNameContains(String name);
}
