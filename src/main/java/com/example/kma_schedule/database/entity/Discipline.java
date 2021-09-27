package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "disciplines")
public class Discipline {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer disciplineId;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "lecturers_teach",
            joinColumns = @JoinColumn(name = "disciplineId"),
            inverseJoinColumns = @JoinColumn(name = "lecturerId"))
    private Set<Lecturer> instructors;
}
