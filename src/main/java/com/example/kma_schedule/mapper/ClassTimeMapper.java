package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.ClassTime;
import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.dto.ClassTimeDto;
import com.example.kma_schedule.dto.LecturerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ClassTimeMapper {
    private final ModelMapper mapper;

    public ClassTimeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ClassTimeDto toDto(ClassTime classTime){
        return Objects.isNull(classTime) ? null : mapper.map(classTime, ClassTimeDto.class);
    }

    public ClassTime toEntity(ClassTimeDto classTimeDto) {
        return Objects.isNull(classTimeDto) ? null : mapper.map(classTimeDto, ClassTime.class);
    }
}
