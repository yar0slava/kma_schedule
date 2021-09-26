package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.database.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> get() {
        return groupRepository.get();
    }

    @Override
    public Group get(String id) {
        return groupRepository.get(id);
    }

    @Override
    public List<Group> findByDegree(String degree) {
        return groupRepository.findByDegree(degree);
    }

    @Override
    public List<Group> findBySpecialization(String specialization) {
        return groupRepository.findBySpecialization(specialization);
    }
}
