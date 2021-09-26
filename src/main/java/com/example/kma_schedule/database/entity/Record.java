package com.example.kma_schedule.database.entity;


import lombok.*;

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


    private Discipline discipline;
    private ClassTime classTime;
    private Group group;
    private Classroom classroom;
    private Lecturer lecturer;
}
