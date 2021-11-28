package com.example.kma_schedule.service;

import com.example.kma_schedule.dto.RecordDto;

import java.util.List;
import java.util.Optional;

public interface RecordService {

    Optional<RecordDto> getById(Integer id);
    void addNewRecord(RecordDto record);
    List<RecordDto> getAll();
    void deleteById(Integer id);
    Optional<RecordDto> update(RecordDto record);
}
