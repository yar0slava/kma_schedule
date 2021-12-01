package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
