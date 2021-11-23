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
@Table(name = "classroom")
public class Classroom {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;

    @Column(name = "name")
    private String name;  //326a

    @Column(name = "capacity")
    private Integer capacity;

    public Classroom(String name, Integer capacity) {
        this.name=name;
        this.capacity=capacity;
    }
}
