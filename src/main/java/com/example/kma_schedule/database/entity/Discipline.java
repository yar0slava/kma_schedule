package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(message = "Discipline ID is mandatory")
    private Integer disciplineId;

    @Column
    @NotBlank(message = "Discipline name is mandatory")
    @Size(min = 5, max = 150)
    private String name;

    @ManyToOne
    @JoinTable(name = "lecturer_teaches",
            joinColumns = @JoinColumn(name = "lecturerId"))
    private Lecturer lecturer;
}
