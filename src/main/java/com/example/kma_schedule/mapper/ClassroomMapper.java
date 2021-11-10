package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.Classroom;
import com.example.kma_schedule.dto.ClassroomDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class ClassroomMapper {
    private final ModelMapper mapper;

    public ClassroomMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ClassroomDto toDto(Classroom classroom){
        return Objects.isNull(classroom) ? null : mapper.map(classroom, ClassroomDto.class);
    }

    public Classroom toEntity(ClassroomDto classroomDto) {
        return Objects.isNull(classroomDto) ? null : mapper.map(classroomDto, Classroom.class);
    }

}