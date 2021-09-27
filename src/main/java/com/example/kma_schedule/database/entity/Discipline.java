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
    @Column(name = "discipline_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer disciplineId;

    @Column(name = "discipline_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "lecturers_teach",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id"))
    private Set<Lecturer> instructors;
}
