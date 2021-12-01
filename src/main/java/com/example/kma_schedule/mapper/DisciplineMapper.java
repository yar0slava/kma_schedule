package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.Discipline;
import com.example.kma_schedule.database.entity.Lecturer;
import com.example.kma_schedule.database.repository.LecturerRepository;
import com.example.kma_schedule.dto.DisciplineDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class DisciplineMapper {
    private final ModelMapper mapper;
    private final LecturerRepository lecturerRepository;

    public DisciplineMapper(ModelMapper mapper, LecturerRepository lecturerRepository) {
        this.mapper = mapper;
        this.lecturerRepository = lecturerRepository;
    }

    public DisciplineDto toDto(Discipline discipline) {

        if (Objects.isNull(discipline)) {
            return null;
        } else {
            DisciplineDto disciplineDto = mapper.map(discipline, DisciplineDto.class);
            disciplineDto.setLecturerId(discipline.getLecturer().getLecturerId());
            return disciplineDto;
        }
    }

    public Discipline toEntity(DisciplineDto disciplineDto) {

        if (Objects.isNull(disciplineDto)) {
            return null;
        } else {
            Discipline discipline = mapper.map(disciplineDto, Discipline.class);
            Optional<Lecturer> lecturer = lecturerRepository.findById(disciplineDto.getLecturerId());
            discipline.setLecturer(lecturer.isPresent() ? lecturer.get() : null);
            return discipline;
        }
    }
}
