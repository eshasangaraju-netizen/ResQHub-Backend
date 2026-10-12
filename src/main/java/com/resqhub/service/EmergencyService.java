package com.resqhub.service;

import com.resqhub.model.EmergencyRequest;
import com.resqhub.repository.EmergencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyService {

    private final EmergencyRepository repository;

    public EmergencyService(EmergencyRepository repository) {
        this.repository = repository;
    }

    public List<EmergencyRequest> getAllEmergencies() {
        return repository.findAll();
    }

    public EmergencyRequest getEmergencyById(int id) {
        return repository.findById(id).orElse(null);
    }

    public EmergencyRequest createEmergency(EmergencyRequest emergency) {

        if (emergency.getStatus() == null ||
            emergency.getStatus().isEmpty()) {

            emergency.setStatus("REPORTED");
        }

        return repository.save(emergency);
    }

    public EmergencyRequest updateEmergency(
            int id,
            EmergencyRequest emergency) {

        EmergencyRequest existing =
                repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setType(emergency.getType());
        existing.setLocation(emergency.getLocation());
        existing.setSeverity(emergency.getSeverity());
        existing.setPeopleAffected(emergency.getPeopleAffected());
        existing.setStatus(emergency.getStatus());
        existing.setUserId(emergency.getUserId());
        existing.setVolunteerId(emergency.getVolunteerId());

        return repository.save(existing);
    }

    public void deleteEmergency(int id) {
        repository.deleteById(id);
    }
}
