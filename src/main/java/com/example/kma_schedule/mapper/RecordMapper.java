package com.example.kma_schedule.mapper;

import com.example.kma_schedule.database.entity.*;
import com.example.kma_schedule.database.entity.Record;
import com.example.kma_schedule.database.repository.*;
import com.example.kma_schedule.dto.FullRecordDto;
import com.example.kma_schedule.dto.RecordDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class RecordMapper {

    private final ModelMapper mapper;
    private final LecturerRepository lecturerRepository;
    private final DisciplineRepository disciplineRepository;
    private final ClassroomRepository classroomRepository;
    private final ClassTimeRepository classTimeRepository;
    private final GroupRepository groupRepository;

    public RecordMapper(ModelMapper mapper, LecturerRepository lecturerRepository, DisciplineRepository disciplineRepository, ClassroomRepository classroomRepository, ClassTimeRepository classTimeRepository, GroupRepository groupRepository) {
        this.mapper = mapper;
        this.lecturerRepository = lecturerRepository;
        this.disciplineRepository = disciplineRepository;
        this.classroomRepository = classroomRepository;
        this.classTimeRepository = classTimeRepository;
        this.groupRepository = groupRepository;
    }

    public RecordDto toDto(Record record) {

        if (Objects.isNull(record)) {
            return null;
        } else {
            RecordDto recordDto = mapper.map(record, RecordDto.class);

            recordDto.setLecturerId(record.getLecturer().getLecturerId());
            recordDto.setClassroomId(record.getClassroom().getClassroomId());
            recordDto.setClassTimeId(record.getClassTime().getClassTimeId());
            recordDto.setDisciplineId(record.getDiscipline().getDisciplineId());
            recordDto.setGroupId(record.getGroup().getId());

            return recordDto;
        }
    }

    public FullRecordDto toFullDto(Record record) {

        if (Objects.isNull(record)) {
            return null;
        } else {
            FullRecordDto recordDto = mapper.map(record, FullRecordDto.class);

            recordDto.setLecturerId(record.getLecturer().getLecturerId());

            recordDto.setLecturerName(record.getLecturer().getName());
            recordDto.setLecturerMiddlename(record.getLecturer().getMiddlename());
            recordDto.setLecturerSurname(record.getLecturer().getSurname());

            recordDto.setClassroomId(record.getClassroom().getClassroomId());
            recordDto.setClassroomName(record.getClassroom().getName());

            recordDto.setClassTimeId(record.getClassTime().getClassTimeId());
            recordDto.setClassTime(record.getClassTime().getClassTime());
            recordDto.setWeekDay(record.getClassTime().getWeekDay());
            recordDto.setWeekNumber(record.getClassTime().getWeekNumber());

            recordDto.setDisciplineId(record.getDiscipline().getDisciplineId());
            recordDto.setDisciplineName(record.getDiscipline().getName());

            recordDto.setGroupId(record.getGroup().getId());
            recordDto.setGroupNumber(record.getGroup().getGroupNumber());

            return recordDto;
        }
    }

    public Record toEntity(RecordDto recordDto) {

        if (Objects.isNull(recordDto)) {
            return null;
        } else {
            Record record = new Record();
            record.setId(recordDto.getId());

            Optional<Lecturer> lecturer = lecturerRepository.findById(recordDto.getLecturerId());
            record.setLecturer(lecturer.isPresent() ? lecturer.get() : null);

            Optional<Discipline> discipline = disciplineRepository.findById(recordDto.getDisciplineId());
            record.setDiscipline(discipline.isPresent() ? discipline.get() : null);

            Optional<Group> group = groupRepository.findById(recordDto.getGroupId());
            record.setGroup(group.isPresent() ? group.get() : null);

            Optional<Classroom> classroom = classroomRepository.findById(recordDto.getClassroomId());
            record.setClassroom(classroom.isPresent() ? classroom.get() : null);

            Optional<ClassTime> classTime = classTimeRepository.findById(recordDto.getClassTimeId());
            record.setClassTime(classTime.isPresent() ? classTime.get() : null);
            
            return record;
        }
    }
}
