package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.WorkflowEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface WorkflowRepository extends MongoRepository<WorkflowEntity, String> {

    List<WorkflowEntity> findAll();
    WorkflowEntity findByName(String name);
    Optional<WorkflowEntity> findById(String id);
}
