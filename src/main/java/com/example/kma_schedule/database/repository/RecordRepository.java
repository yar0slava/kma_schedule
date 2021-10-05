package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Record;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RecordRepository extends CrudRepository<Record, Integer> {
List<Record> find();
}
