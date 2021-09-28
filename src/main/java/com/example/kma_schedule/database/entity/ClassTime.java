package com.example.kma_schedule.database.entity;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "classDate")
    private LocalDate classDate;

    @Column(name = "classTime")
    private LocalTime classTime;

    @Column(name = "weekNumber")
    private Integer weekNumber;
}
