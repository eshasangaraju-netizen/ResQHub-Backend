package com.resqhub.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
@Column(name = "created_at", nullable = false, updatable = false)
private LocalDateTime createdAt;

    private String type;

    private String location;

    private String severity;

    private int peopleAffected;

    private String status;

    private Integer userId;

    private Integer volunteerId;

    public EmergencyRequest() {
    }

    public EmergencyRequest(String type, String location,
                            String severity, int peopleAffected,
                            String status, Integer userId,
                            Integer volunteerId) {

        this.type = type;
        this.location = location;
        this.severity = severity;
        this.peopleAffected = peopleAffected;
        this.status = status;
        this.userId = userId;
        this.volunteerId = volunteerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public int getPeopleAffected() {
        return peopleAffected;
    }

    public void setPeopleAffected(int peopleAffected) {
        this.peopleAffected = peopleAffected;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }
}
