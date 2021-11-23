package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "ID is mandatory")
    private Integer lecturerId;

    @Column
    @NotBlank(message = "Lecturer full name is mandatory")
    private String name;
}
