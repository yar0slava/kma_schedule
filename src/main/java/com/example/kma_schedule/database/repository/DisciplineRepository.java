package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Discipline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
}
