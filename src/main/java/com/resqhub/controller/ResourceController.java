package com.resqhub.controller;

import com.resqhub.model.Resource;
import com.resqhub.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "http://localhost:5173")
public class ResourceController {

    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resource> getAll() {
        return service.getAllResources();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getById(
            @PathVariable int id) {

        Resource resource =
                service.getResourceById(id);

        if (resource == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public Resource create(
            @RequestBody Resource resource) {

        return service.createResource(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> update(
            @PathVariable int id,
            @RequestBody Resource resource) {

        Resource updated =
                service.updateResource(id, resource);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable int id) {

        service.deleteResource(id);

        return ResponseEntity.noContent().build();
    }
}
