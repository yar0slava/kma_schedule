package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Record;
import java.util.List;
import java.util.Optional;

public interface RecordService {

    Optional<Record> getById(Integer id);
    void addNewRecord(Record record);
    List<Record> getAll();
}
