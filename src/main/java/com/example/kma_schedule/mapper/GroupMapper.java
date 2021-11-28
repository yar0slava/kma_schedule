package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.database.repository.LecturerRepository;
import com.example.kma_schedule.dto.GroupDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.Objects;
import java.util.Optional;

@Component
public class GroupMapper {
    private final ModelMapper mapper;
    private final LecturerRepository lecturerRepository;

    public GroupMapper(ModelMapper mapper, LecturerRepository lecturerRepository) {
        this.mapper = mapper;
        this.lecturerRepository = lecturerRepository;
    }

    public GroupDto toDto(Group group){

        if (Objects.isNull(group)) {
            return null;
        } else {
            GroupDto groupDto = mapper.map(group, GroupDto.class);
            groupDto.setLecturerId(group.getLecturer().getLecturerId());
            return groupDto;
        }
    }

    public Group toEntity(GroupDto groupDto) {

        if (Objects.isNull(groupDto)) {
            return null;
        } else {
            Group group = mapper.map(groupDto, Group.class);
            Optional<Lecturer> lecturer = lecturerRepository.findById(groupDto.getLecturerId());
            group.setLecturer(lecturer.isPresent() ? lecturer.get() : null);
            return group;
        }
    }
}
