package com.sportsperformance.admin_service.controller;

import com.sportsperformance.admin_service.dto.EventDTO;
import com.sportsperformance.admin_service.model.Event;
import com.sportsperformance.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-event")
    public ResponseEntity<String> createEvent(@RequestBody EventDTO eventDTO) {
        Event event = new Event(null, eventDTO.getName(), eventDTO.getDescription(), eventDTO.getLocation(), eventDTO.getDate(), "PENDING");
        adminService.createEvent(event);
        return new ResponseEntity<>("Event created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return adminService.getAllEvents();
    }
}

