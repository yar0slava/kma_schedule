package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.ClassTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTimeRepository extends CrudRepository<ClassTime, Integer> {
}
