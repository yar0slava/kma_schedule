package com.example.kma_schedule.service;

import com.example.kma_schedule.dto.LecturerDto;

import java.util.List;
import java.util.Optional;

public interface LecturerService {
    List<LecturerDto> getAll();
    Optional<LecturerDto> getById(Integer id);
    void addNewLecturer(LecturerDto lecturer);
    void deleteById(Integer id);
    Optional<LecturerDto> update(LecturerDto lecturer);
}
