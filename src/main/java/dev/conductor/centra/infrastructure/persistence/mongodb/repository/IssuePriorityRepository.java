package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssuePriorityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IssuePriorityRepository extends MongoRepository<IssuePriorityEntity, String> {

    IssuePriorityEntity findByLabel(String label);
    Optional<IssuePriorityEntity> findById(String id);
}
