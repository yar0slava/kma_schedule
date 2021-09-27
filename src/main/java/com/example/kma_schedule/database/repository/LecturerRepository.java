package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.database.entity.Lecturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LecturerRepository  extends CrudRepository<Lecturer, Integer> {
}
