package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.dto.LecturerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LecturerMapper {
    private final ModelMapper mapper;

    public LecturerMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public LecturerDto toDto(Lecturer lecturer){
        return Objects.isNull(lecturer) ? null : mapper.map(lecturer, LecturerDto.class);
    }

    public Lecturer toEntity(LecturerDto lecturerDto) {
        return Objects.isNull(lecturerDto) ? null : mapper.map(lecturerDto, Lecturer.class);
    }
}
