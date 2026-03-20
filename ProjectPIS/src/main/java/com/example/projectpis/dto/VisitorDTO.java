package com.example.projectpis.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class VisitorDTO {

    public LocalTime arrivalTime;
    public LocalTime leaveTime;

    public boolean sunbed;
    public boolean swimGear;
    public boolean mattress;

    public Long dutyId;
}