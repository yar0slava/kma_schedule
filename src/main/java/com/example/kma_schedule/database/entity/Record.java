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

    @Column
    private ClassTime classTime;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @Column
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturer;
}
