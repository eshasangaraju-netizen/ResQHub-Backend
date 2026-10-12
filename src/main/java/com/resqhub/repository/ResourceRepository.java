package com.resqhub.repository;

import com.resqhub.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository
        extends JpaRepository<Resource, Integer> {
}
