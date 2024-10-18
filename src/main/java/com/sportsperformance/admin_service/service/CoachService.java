package com.sportsperformance.admin_service.service;


import com.sportsperformance.admin_service.model.Athlete;
import com.sportsperformance.admin_service.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private AthleteRepository athleteRepository;

    public Athlete registerAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }
}

