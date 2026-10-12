package com.resqhub.repository;

import com.resqhub.model.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository
        extends JpaRepository<EmergencyRequest, Integer> {
}
