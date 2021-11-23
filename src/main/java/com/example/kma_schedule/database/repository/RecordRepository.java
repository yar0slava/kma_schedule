package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
}
