package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IssueTypeRepository extends MongoRepository<IssueTypeEntity, String> {

    IssueTypeEntity findByLabel(String label);
    Optional<IssueTypeEntity> findById(String id);
}
