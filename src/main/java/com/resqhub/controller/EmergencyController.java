package com.resqhub.controller;

import com.resqhub.model.EmergencyRequest;
import com.resqhub.service.EmergencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencies")
@CrossOrigin(origins = "http://localhost:5173")
public class EmergencyController {

    private final EmergencyService service;

    public EmergencyController(EmergencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmergencyRequest> getAll() {
        return service.getAllEmergencies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyRequest> getById(
            @PathVariable int id) {

        EmergencyRequest emergency =
                service.getEmergencyById(id);

        if (emergency == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(emergency);
    }

    @PostMapping
    public EmergencyRequest create(
            @RequestBody EmergencyRequest emergency) {

        return service.createEmergency(emergency);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyRequest> update(
            @PathVariable int id,
            @RequestBody EmergencyRequest emergency) {

        EmergencyRequest updated =
                service.updateEmergency(id, emergency);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable int id) {

        service.deleteEmergency(id);

        return ResponseEntity.noContent().build();
    }
}
