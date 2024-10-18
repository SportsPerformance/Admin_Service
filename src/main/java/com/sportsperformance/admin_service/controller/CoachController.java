package com.sportsperformance.admin_service.controller;

import com.sportsperformance.admin_service.dto.AthleteDTO;
import com.sportsperformance.admin_service.model.Athlete;
import com.sportsperformance.admin_service.model.Event;
import com.sportsperformance.admin_service.service.AdminService;
import com.sportsperformance.admin_service.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/register-athlete")
    public ResponseEntity<String> registerAthlete(@RequestBody AthleteDTO athleteDTO) {
        Event event = adminService.getAllEvents().stream()
                .filter(e -> e.getId().equals(athleteDTO.getEventId()))
                .findFirst()
                .orElse(null);

        Athlete athlete = new Athlete(null, athleteDTO.getName(), athleteDTO.getEmail(), event);
        coachService.registerAthlete(athlete);
        return new ResponseEntity<>("Athlete registered successfully", HttpStatus.CREATED);
    }

    @GetMapping("/athletes")
    public List<Athlete> getAllAthletes() {
        return coachService.getAllAthletes();
    }
}
