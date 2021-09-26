package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "discipline")
    private Discipline discipline;

    @Column(name = "class_time")
    private ClassTime classTime;

    @Column(name = "group")
    private Group group;

    @Column(name = "classroom")
    private Classroom classroom;

    @Column(name = "lecturer")
    private Lecturer lecturer;
}
