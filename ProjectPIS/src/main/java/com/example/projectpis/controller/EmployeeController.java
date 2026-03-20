package com.example.projectpis.controller;

import com.example.projectpis.dto.VisitorDTO;
import com.example.projectpis.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final VisitorService service;

    @PostMapping("/visitor")
    public void addVisitor(@RequestBody VisitorDTO dto) {
        service.addVisitor(dto);
    }
}
