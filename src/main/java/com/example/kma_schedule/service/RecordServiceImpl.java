package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.entity.WeekDay;
import com.example.kma_schedule.database.repository.RecordRepository;
import com.example.kma_schedule.dto.FullRecordDto;
import com.example.kma_schedule.dto.RecordDto;
import com.example.kma_schedule.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecordServiceImpl implements RecordService{


    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public Optional<RecordDto> getById(Integer id) {
        Record record = recordRepository.findById(id).get();
        return Optional.of(recordMapper.toDto(record));
    }

    @Override
    public void addNewRecord(RecordDto recordDto) {
        Record record = recordMapper.toEntity(recordDto);
        recordRepository.save(record);
    }

    @Override
    @Cacheable(value = "records")
    public List<RecordDto> getAll() {
        return StreamSupport.stream(
                        recordRepository.findAll().spliterator(), false )
                .map(recordMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FullRecordDto> getAllFull() {
        return StreamSupport.stream(
                        recordRepository.findAll().spliterator(), false )
                .map(recordMapper::toFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FullRecordDto> getByLecturerId(Integer lecturerId) {
        return StreamSupport.stream(
                        recordRepository.findByLecturer_LecturerId(lecturerId).spliterator(), false )
                .map(recordMapper::toFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecordDto> getByGroupId(Integer groupId) {
        return StreamSupport.stream(
                        recordRepository.findByGroup_Id(groupId).spliterator(), false )
                .map(recordMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FullRecordDto> getByDisciplineId(Integer disciplineId) {
        return StreamSupport.stream(
                        recordRepository.findByDiscipline_DisciplineId(disciplineId).spliterator(), false )
                .map(recordMapper::toFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecordDto> getByWeekDayAndWeekNumber(WeekDay weekDay, Integer weekNumber) {
        return StreamSupport.stream(
                        recordRepository.findByClassTime_WeekDayAndClassTime_WeekNumber(weekDay, weekNumber).spliterator(), false )
                .map(recordMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = "records", allEntries = true)
    public void deleteById(Integer id) {
        recordRepository.deleteById(id);
    }

    @Override
    public Optional<RecordDto> update(RecordDto recordDto) {
        Record record = recordRepository.save(recordMapper.toEntity(recordDto));
        return Optional.of(recordMapper.toDto(record));
    }
}