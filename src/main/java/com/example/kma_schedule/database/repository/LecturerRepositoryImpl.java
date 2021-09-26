package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LecturerRepositoryImpl implements LecturerRepository {

//    @Autowired
//    private EntityManager entityManager;

    @Override
    public List<Lecturer> get() {
        return null;
    }

    @Override
    public Lecturer get(int id) {
        return null;
    }
}