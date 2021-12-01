package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
