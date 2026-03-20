package com.example.projectpis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Duty {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    private LocalTime startTime;
    private LocalTime endTime;

    private String zone;

    @ManyToOne
    private User employee;
}