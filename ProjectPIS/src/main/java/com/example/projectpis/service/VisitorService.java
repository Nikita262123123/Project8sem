package com.example.projectpis.service;

import com.example.projectpis.dto.VisitorDTO;
import com.example.projectpis.entity.BeachVisitor;
import com.example.projectpis.entity.Duty;
import com.example.projectpis.repository.BeachVisitorRepository;
import com.example.projectpis.repository.DutyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final BeachVisitorRepository repo;
    private final DutyRepository dutyRepo;

    public void addVisitor(VisitorDTO dto) {
        Duty duty = dutyRepo.findById(dto.dutyId).orElseThrow();

        BeachVisitor v = new BeachVisitor();
        v.setArrivalTime(dto.arrivalTime);
        v.setLeaveTime(dto.leaveTime);
        v.setSunbed(dto.sunbed);
        v.setSwimGear(dto.swimGear);
        v.setMattress(dto.mattress);
        v.setDuty(duty);

        repo.save(v);
    }
}