package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.ClassTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassTimeRepository extends JpaRepository<ClassTime, Integer> {
}
