package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;

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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "disciplineId")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "classTimeId")
    private ClassTime classTime;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "classroomId")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturer;
}
