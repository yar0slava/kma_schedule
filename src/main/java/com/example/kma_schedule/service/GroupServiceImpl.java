package com.example.kma_schedule.service;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.database.repository.GroupRepository;
import com.example.kma_schedule.dto.GroupDto;
import com.example.kma_schedule.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public List<GroupDto> getAll() {
        return StreamSupport.stream(
                        groupRepository.findAll().spliterator(), false )
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GroupDto> getById(String id) {
        Group group = groupRepository.findById(id).get();
        return Optional.of(groupMapper.toDto(group));
    }

    @Override
    public void addNewGroup(GroupDto groupDto) {
        Group group1 = groupMapper.toEntity(groupDto);
        groupRepository.save(group1);
    }

    @Override
    public List<GroupDto> findByDegree(String degree) {
        return StreamSupport.stream(
                        groupRepository.findByDegree(degree).spliterator(), false )
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupDto> findBySpecialization(String specialization) {
        return StreamSupport.stream(
                        groupRepository.findBySpecialization(specialization).spliterator(), false )
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Optional<GroupDto> update(GroupDto groupDto) {
        Group group = groupRepository.save(groupMapper.toEntity(groupDto));
        return Optional.of(groupMapper.toDto(group));
    }
}