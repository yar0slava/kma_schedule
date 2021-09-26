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
@Table(name="group")
public class Group {

    @Id
    @Column
    private String groupId; //КН_МП1 КН_МП2, ід кожної групи предмету для практики, для лекції ід=L

    @Column
    private Boolean isLecture;

    @Column
    private Integer amount; //amount of students in group

    @Column
    private String specialization; //Computer Science, Software Engineer, ..

    @Column
    private String degree; //Bachelor, Master

    @ManyToOne
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturer;
}
