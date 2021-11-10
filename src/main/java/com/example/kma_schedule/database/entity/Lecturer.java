package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "ID is mandatory")
    @Size(min = 6, max = 6)
    private Integer lecturerId;

    @Column
    @NotBlank(message = "Lecturer full name is mandatory")
    private String name;
}
