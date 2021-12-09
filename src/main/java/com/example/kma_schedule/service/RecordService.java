package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.WeekDay;
import com.example.kma_schedule.dto.FullRecordDto;
import com.example.kma_schedule.dto.RecordDto;

import java.util.List;
import java.util.Optional;

public interface RecordService {

    Optional<RecordDto> getById(Integer id);
    void addNewRecord(RecordDto record);
    List<RecordDto> getAll();
    void deleteById(Integer id);
    Optional<RecordDto> update(RecordDto record);

    List<FullRecordDto> getAllFull();

    List<FullRecordDto> getByLecturerId(Integer lecturerId);
    List<RecordDto> getByGroupId(Integer groupId);
    List<FullRecordDto> getByDisciplineId(Integer disciplineId);
    List<RecordDto> getByWeekDayAndWeekNumber(WeekDay weekDay, Integer weekNumber);
}
