package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="record")
public class Record {

    @Id
    @NotNull(message = "ID is mandatory")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "disciplineId")
    @NotNull
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "classTimeId")
    @NotNull
    private ClassTime classTime;

    @ManyToOne
    @JoinColumn(name = "groupId")
    @NotNull
    private Group group;

    @ManyToOne
    @JoinColumn(name = "classroomId")
    @NotNull
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "lecturerId")
    @NotNull
    private Lecturer lecturer;
}
