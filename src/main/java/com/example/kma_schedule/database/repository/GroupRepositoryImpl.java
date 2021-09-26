package com.example.kma_schedule.database.repository;

import com.example.kma_schedule.database.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

//    @Autowired
//    private EntityManager entityManager;

    @Override
    public List<Group> get() {
        return null;
    }

    @Override
    public Group get(String id) {
        return null;
    }

    @Override
    public List<Group> findByDegree(String degree) {
        return null;
    }

    @Override
    public List<Group> findBySpecialization(String specialization) {
        return null;
    }
}
