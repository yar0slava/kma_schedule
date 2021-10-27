package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotBlank(message = "ID is mandatory")
    @Size(min = 6, max = 6)
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
