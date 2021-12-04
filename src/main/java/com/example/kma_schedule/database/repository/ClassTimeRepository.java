package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.ClassTime;
import com.example.kma_schedule.database.entity.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassTimeRepository extends JpaRepository<ClassTime, Integer> {

    List<ClassTime> findByWeekDayAndWeekNumber(WeekDay weekDay, Integer weekNumber);
}
