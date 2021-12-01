package com.example.kma_schedule;

import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.database.repository.LecturerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class SpringDataTest {

    @Autowired
    LecturerRepository lecturerRepository;

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
}
