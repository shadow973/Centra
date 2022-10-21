package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.CustomFieldValueEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomFieldValueRepository extends MongoRepository<CustomFieldValueEntity, String> {

    List<CustomFieldValueEntity> findByIssueId(String id);
}
