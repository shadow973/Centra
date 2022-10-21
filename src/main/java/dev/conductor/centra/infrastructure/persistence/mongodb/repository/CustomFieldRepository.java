package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.CustomFieldEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomFieldRepository extends MongoRepository<CustomFieldEntity, String> {
    CustomFieldEntity findByName(String name);
    List<CustomFieldEntity> findByProjectId(String projectId);
}
