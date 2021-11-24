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
    private Integer lecturerId;

    @Column
    @NotBlank(message = "Lecturer name is mandatory")
    private String name;

    @Column
    @NotBlank(message = "Lecturer surname is mandatory")
    private String surname;

    @Column
    @NotBlank(message = "Lecturer middlename is mandatory")
    private String middlename;
}
