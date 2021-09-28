package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService{

    private RecordRepository recordRepository;

    @Autowired
    public void setRecordRepository(RecordRepository recordRepository){
        this.recordRepository = recordRepository;
    }


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
}
