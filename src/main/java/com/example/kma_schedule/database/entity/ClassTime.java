package com.example.kma_schedule.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "classtime")
public class ClassTime {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classTimeId;

    @Column(name = "classDay")
    private WeekDay weekDay;

    @Column(name = "classTime")
    private LocalTime classTime;

    @Column(name = "weekNumber")
    private Integer weekNumber;
}
