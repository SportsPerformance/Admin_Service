package com.sportsperformance.admin_service.dto;

import lombok.Data;

@Data
public class EventDTO {
    private String name;
    private String description;
    private String location;
    private String date;
}
