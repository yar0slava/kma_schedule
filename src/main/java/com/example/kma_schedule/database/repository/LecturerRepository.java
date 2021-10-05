package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.database.entity.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public interface LecturerRepository  extends CrudRepository<Lecturer, Integer> {
}
