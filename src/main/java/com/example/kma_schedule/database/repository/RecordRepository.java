package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.entity.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    List<Record> findByLecturer_LecturerId(Integer lecturerId);

    List<Record> findByGroup_Id(Integer groupId);

    List<Record> findByDiscipline_DisciplineId(Integer disciplineId);

    List<Record> findByClassTime_WeekDayAndClassTime_WeekNumber(WeekDay weekDay, Integer weekNumber);
}
