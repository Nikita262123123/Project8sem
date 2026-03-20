package com.example.projectpis.repository;

import com.example.projectpis.entity.BeachVisitor;
import com.example.projectpis.entity.Duty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeachVisitorRepository extends JpaRepository<BeachVisitor, Long> {
    List<BeachVisitor> findByDuty(Duty duty);
}