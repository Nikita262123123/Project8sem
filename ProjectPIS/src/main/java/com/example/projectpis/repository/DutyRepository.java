package com.example.projectpis.repository;

import com.example.projectpis.entity.Duty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DutyRepository extends JpaRepository<Duty, Long> {
    List<Duty> findByDateBetweenAndZone(LocalDate start, LocalDate end, String zone);
}