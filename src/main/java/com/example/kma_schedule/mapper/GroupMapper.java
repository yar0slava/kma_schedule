package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.Group;
import com.example.kma_schedule.dto.GroupDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class GroupMapper {
    private final ModelMapper mapper;

    public GroupMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public GroupDto toDto(Group group){
        return Objects.isNull(group) ? null : mapper.map(group, GroupDto.class);
    }

    public Group toEntity(GroupDto groupDto) {
        return Objects.isNull(groupDto) ? null : mapper.map(groupDto, Group.class);
    }
}
