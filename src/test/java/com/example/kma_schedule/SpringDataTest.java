package com.example.kma_schedule;

import com.example.kma_schedule.database.entity.Classroom;
import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.database.repository.ClassroomRepository;
import com.example.kma_schedule.database.repository.LecturerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class SpringDataTest {

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Test
    public void dataTest() {
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
    public void classroomTest() {
        List<Classroom> emptyClassrooms = (List<Classroom>) classroomRepository.findAll();
        Assertions.assertTrue(emptyClassrooms.isEmpty());

        List<Classroom> classrooms = new ArrayList<Classroom>();

        Classroom classroom = new Classroom(111, "GR2", 100);
        classrooms.add(classroom);
        classrooms.add(new Classroom(112, "GR1", 30));
        classrooms.add(new Classroom(113, "GR3", 40));
        classroomRepository.saveAll(classrooms);

//        Optional<Classroom> test = classroomRepository.findByName("GR2");
//        Assertions.assertEquals(classroom.getName(), test.get().getName());
    }
}
