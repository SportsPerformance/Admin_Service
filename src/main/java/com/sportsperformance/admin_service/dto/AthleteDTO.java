package com.sportsperformance.admin_service.dto;

import lombok.Data;

@Data
public class AthleteDTO {
    private String name;
    private String email;
    private Long eventId;  // Link to Event
}
