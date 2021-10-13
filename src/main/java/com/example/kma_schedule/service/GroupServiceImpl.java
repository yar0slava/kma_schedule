package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.database.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> getAll() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Optional<Group> getById(String id) {
        return groupRepository.findById(id);
    }

    @Override
    public void addNewGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public List<Group> findByDegree(String degree) {
        return groupRepository.findByDegree(degree);
    }

    @Override
    public List<Group> findBySpecialization(String specialization) {
        return groupRepository.findBySpecialization(specialization);
    }

    @Override
    public void deleteById(String id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Optional<Group> update(Group group) {
        return Optional.of(groupRepository.save(group));
    }
}