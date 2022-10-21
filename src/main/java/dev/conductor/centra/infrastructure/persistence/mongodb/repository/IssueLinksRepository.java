package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueLinksEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IssueLinksRepository extends MongoRepository<IssueLinksEntity, String> {
    List<IssueLinksEntity> findByNodePublicId(String id);
    List<IssueLinksEntity> findByLinkPublicId(String id);
}
