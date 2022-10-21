package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<ProjectEntity, String> {

    ProjectEntity findByProjectKey(String key);
    ProjectEntity findByProjectName(String name);
    Optional<ProjectEntity> findById(String id);
}
