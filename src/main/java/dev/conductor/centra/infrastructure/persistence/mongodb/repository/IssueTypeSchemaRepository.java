package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueTypeSchemaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IssueTypeSchemaRepository extends MongoRepository<IssueTypeSchemaEntity, String>  {

    IssueTypeSchemaEntity findByName(String name);
    Optional<IssueTypeSchemaEntity> findById(String id);
}
