package com.example.projectpis.service;

import com.example.projectpis.entity.Duty;
import org.springframework.stereotype.Service;

@Service
public class GoogleCalendarService {

    public void createEvent(Duty duty) {
        System.out.println("Google Calendar: создано событие на дату " + duty.getDate());
    }
}
