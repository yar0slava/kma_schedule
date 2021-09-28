package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer lecturerId;

    @Column
    private String name;

    @ManyToMany(mappedBy = "instructors")
    private Set<Discipline> disciplines;

}
