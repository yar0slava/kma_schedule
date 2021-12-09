package com.example.kma_schedule;

import com.example.kma_schedule.database.entity.*;
import com.example.kma_schedule.database.repository.ClassTimeRepository;
import com.example.kma_schedule.database.repository.ClassroomRepository;
import com.example.kma_schedule.database.repository.GroupRepository;
import com.example.kma_schedule.database.repository.LecturerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class SpringDataTest {

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ClassTimeRepository classTimeRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void whenSaveAll_thenReturnAll() {
        List<Lecturer> emptyLectures = (List<Lecturer>) lecturerRepository.findAll();
        Assertions.assertTrue(emptyLectures.isEmpty());

        List<Lecturer> lectures = new ArrayList<Lecturer>();
        lectures.add(new Lecturer(121, "name1", "surname1", "middlename1"));
        lectures.add(new Lecturer(122, "name2", "surname2", "middlename2"));
        lectures.add(new Lecturer(123, "name3", "surname3", "middlename3"));
        lecturerRepository.saveAll(lectures);

        List<Lecturer> testLectures = (List<Lecturer>) lecturerRepository.findAll();
        Assertions.assertEquals(lectures.size(), testLectures.size());
    }

    @Test
    public void whenAddAll_thenContains() {
        List<Classroom> emptyClassrooms = (List<Classroom>) classroomRepository.findAll();
        Assertions.assertTrue(emptyClassrooms.isEmpty());

        List<Classroom> classrooms = new ArrayList<Classroom>();

        Classroom classroom = new Classroom(111, "GR2", 100);
        classrooms.add(classroom);
        classrooms.add(new Classroom(112, "GR1", 30));
        classrooms.add(new Classroom(113, "GR3", 40));
        classroomRepository.saveAll(classrooms);

        List<Classroom> test = classroomRepository.findByNameContains("GR2");
        Assertions.assertTrue(test.contains(classroom));
    }

    @Test
    public void whenContainsWeekDayAndWeekNumber_thenReturnClassTime() {
        List<ClassTime> emptyTimes = (List<ClassTime>) classTimeRepository.findAll();
        Assertions.assertTrue(emptyTimes.isEmpty());

        List<ClassTime> times = new ArrayList<ClassTime>();
        LocalTime time = LocalTime.parse("9:15:00");
        times.add(new ClassTime(1112, WeekDay.MONDAY, time, 2));
        times.add(new ClassTime(1112, WeekDay.TUESDAY, time, 3));
        times.add(new ClassTime(1113, WeekDay.WEDNESDAY, time, 1));
        times.add(new ClassTime(1114, WeekDay.MONDAY, time, 1));
        times.add(new ClassTime(1114, WeekDay.SATURDAY, time, 2));
        classTimeRepository.saveAll(times);

        List<ClassTime> test = classTimeRepository.findByWeekDayAndWeekNumber(WeekDay.MONDAY, 1);
        Assertions.assertEquals(1, test.size());
    }

    @Test
    public void whenContainsSpecializationAndCourse_thenGroup() {
        List<Group> emptyGroups = (List<Group>) groupRepository.findAll();
        Assertions.assertTrue(emptyGroups.isEmpty());

        Lecturer lecturer = new Lecturer(1, "name", "surname", "middlename");
        List<Group> groups = new ArrayList<Group>();
        groups.add(new Group(1, true, "CS", "Bachelor", 4, 1, lecturer));
        groups.add(new Group(2, false, "CS", "Bachelor", 4, 2, lecturer));
        groups.add(new Group(3, true, "SE", "Bachelor", 2, 5, lecturer));
        groups.add(new Group(4, true, "SE", "Master", 4, 2, lecturer));
        groupRepository.saveAll(groups);

        List<Group> test = groupRepository.findBySpecializationAndCourse("CS", 4);
        Assertions.assertEquals(2, test.size());
    }
}
