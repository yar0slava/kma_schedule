package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

    List<Lecturer> findBySurnameContains(String name);
}
