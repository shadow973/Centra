package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueEntity;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@JaversSpringDataAuditable
public interface IssueRepository extends MongoRepository<IssueEntity, String> {

    List<IssueEntity> findByProjectId (String projectId);
    IssueEntity findByProjectIdAndExternalId(String projectId, long externalId);
}
