package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssuePrioritySchemaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IssuePrioritySchemaRepository extends MongoRepository<IssuePrioritySchemaEntity, String> {

    IssuePrioritySchemaEntity findByName(String name);
}
