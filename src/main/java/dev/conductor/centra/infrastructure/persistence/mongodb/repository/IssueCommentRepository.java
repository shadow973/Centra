package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueCommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IssueCommentRepository extends MongoRepository<IssueCommentEntity, String> {

    List<IssueCommentEntity> findByIssueIdOrderByCreatedDateAsc(String id);
}