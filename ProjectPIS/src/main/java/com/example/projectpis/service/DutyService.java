package com.example.projectpis.service;

import com.example.projectpis.entity.Duty;
import com.example.projectpis.entity.User;
import com.example.projectpis.repository.DutyRepository;
import com.example.projectpis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DutyService {

    private final DutyRepository repo;
    private final UserRepository userRepo;
    private final GoogleCalendarService calendarService;

    public void createDuty(Long userId, Duty duty) {
        User user = userRepo.findById(userId).orElseThrow();
        duty.setEmployee(user);
        repo.save(duty);

        calendarService.createEvent(duty);
    }
}