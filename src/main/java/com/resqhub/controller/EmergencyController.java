package com.resqhub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resqhub.model.EmergencyRequest;
import com.resqhub.service.EmergencyService;

@RestController
@RequestMapping("/api/emergencies")
@CrossOrigin(origins = "http://localhost:5173")
public class EmergencyController {

    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @GetMapping
    public List<EmergencyRequest> getAllEmergencies() {
        return emergencyService.getAllEmergencies();
    }

    @GetMapping("/{id}")
    public EmergencyRequest getEmergencyById(@PathVariable Integer id) {
        return emergencyService.getEmergencyById(id);
    }

    @PostMapping
    public EmergencyRequest createEmergency(
            @RequestBody EmergencyRequest emergency) {
        return emergencyService.createEmergency(emergency);
    }

    @PutMapping("/{id}")
    public EmergencyRequest updateEmergency(
            @PathVariable Integer id,
            @RequestBody EmergencyRequest emergency) {
        return emergencyService.updateEmergency(id, emergency);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergency(@PathVariable Integer id) {
        emergencyService.deleteEmergency(id);
    }
}
