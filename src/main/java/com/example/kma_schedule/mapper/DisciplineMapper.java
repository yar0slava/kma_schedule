package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.dto.DisciplineDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DisciplineMapper {
    private final ModelMapper mapper;

    public DisciplineMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public DisciplineDto toDto(Discipline discipline){
        return Objects.isNull(discipline) ? null : mapper.map(discipline, DisciplineDto.class);
    }

    public Discipline toEntity(DisciplineDto disciplineDto) {
        return Objects.isNull(disciplineDto) ? null : mapper.map(disciplineDto, Discipline.class);
    }
}
