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
@Table(name = "stud_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private Boolean isLecture;

    @Column
    private String specialization; //Computer Science, Software Engineer, ..

    @Column
    private String degree; //Bachelor, Master

    @Column
    private Integer course;

    @Column
    private Integer groupNumber;

    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturer;
}
