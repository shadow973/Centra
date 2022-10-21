package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.UserAssociationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserAssociationRepository extends MongoRepository<UserAssociationEntity, String> {

    List<UserAssociationEntity> findByAssociationTypeAndSourceId(String associationType, String sourceId);
    List<UserAssociationEntity> findByAssociationTypeAndSinkNodeEntityAndSinkId(String associationType, String sinkNodeEntity, String sinkId);
}
