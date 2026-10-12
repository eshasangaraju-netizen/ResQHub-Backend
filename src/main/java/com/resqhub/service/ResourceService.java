package com.resqhub.service;

import com.resqhub.model.Resource;
import com.resqhub.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public List<Resource> getAllResources() {
        return repository.findAll();
    }

    public Resource getResourceById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Resource createResource(Resource resource) {
        return repository.save(resource);
    }

    public Resource updateResource(int id, Resource resource) {

        Resource existing =
                repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(resource.getName());
        existing.setQuantity(resource.getQuantity());

        return repository.save(existing);
    }

    public void deleteResource(int id) {
        repository.deleteById(id);
    }
}
