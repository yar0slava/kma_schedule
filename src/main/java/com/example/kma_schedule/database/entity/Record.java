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


    private Discipline discipline;
    private ClassTime classTime;

    @OneToOne
    @JoinColumn(name = "groupId")
    private Group group;

    private Classroom classroom;

    @OneToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturer;
}
