package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Admin;
import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.repository.RecordRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService{


    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Optional<Record> getById(Integer id) {
        return recordRepository.findById(id);
    }

    @Override
    public void addNewRecord(Record record) {
        recordRepository.save(record);
    }

    @Override
    public List<Record> getAll() {
        return (List<Record>) recordRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        recordRepository.deleteById(id);
    }

    @Override
    public Optional<Record> update(Record record) {
        return Optional.of(recordRepository.save(record));
    }
}