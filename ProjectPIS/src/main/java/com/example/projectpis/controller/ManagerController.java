package com.example.projectpis.controller;

import com.example.projectpis.entity.Duty;
import com.example.projectpis.service.DutyService;
import com.example.projectpis.service.GoogleDocsService;
import com.example.projectpis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final UserService userService;
    private final DutyService dutyService;
    private final GoogleDocsService docsService;
    // todo: У тебя нету класса ReportService
    private final ReportService reportService;

    @GetMapping("/users")
    public Object users() {
        return userService.getUnapproved();
    }

    @PutMapping("/approve/{id}")
    public void approve(@PathVariable Long id) {
        userService.approve(id);
    }

    @PostMapping("/duty/{userId}")
    public void createDuty(@PathVariable Long userId, @RequestBody Duty duty) {
        dutyService.createDuty(userId, duty);
    }

    @GetMapping("/report")
    public String report(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam String zone) {

        Object data = reportService.report(
                LocalDate.parse(start),
                LocalDate.parse(end),
                zone
        );

        return docsService.createReport(data);
    }
}