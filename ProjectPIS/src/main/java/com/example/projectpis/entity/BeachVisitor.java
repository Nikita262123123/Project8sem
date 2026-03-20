package com.example.projectpis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class BeachVisitor {

    @Id
    @GeneratedValue
    private Long id;

    private LocalTime arrivalTime;
    private LocalTime leaveTime;

    private boolean sunbed;   // Ш
    private boolean swimGear; // П
    private boolean mattress; // М

    @ManyToOne
    private Duty duty;
}