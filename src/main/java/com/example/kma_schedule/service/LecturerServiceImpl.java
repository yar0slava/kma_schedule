package com.example.kma_schedule.service;

import com.example.kma_schedule.aop.LogExecutionTime;
import com.example.kma_schedule.aop.LogMethodParameters;
import com.example.kma_schedule.database.repository.LecturerRepository;
import com.example.kma_schedule.dto.LecturerDto;
import com.example.kma_schedule.mapper.LecturerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private LecturerMapper lecturerMapper;

    @Override
    public List<LecturerDto> getAll() {
        return StreamSupport.stream(
                        lecturerRepository.findAll().spliterator(), false )
                .map(lecturerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LecturerDto> getById(Integer id) {
        return Optional.of(lecturerMapper.toDto(lecturerRepository.findById(id).get()));
    }

    @Override
    public List<LecturerDto> getByName(String name) {
        return StreamSupport.stream(
                        lecturerRepository.findBySurnameContains(name).spliterator(), false )
                .map(lecturerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @LogMethodParameters
    @LogExecutionTime
    public void addNewLecturer(LecturerDto lecturer) {
        lecturerRepository.save(lecturerMapper.toEntity(lecturer));
    }

    @Override
    public void deleteById(Integer id) {
        lecturerRepository.deleteById(id);
    }

    @Override
    public Optional<LecturerDto> update(LecturerDto lecturer) {
        return Optional.of(lecturerMapper.toDto(lecturerRepository.save(lecturerMapper.toEntity(lecturer))));
    }
}