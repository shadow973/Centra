package dev.conductor.centra.domain.userAssociation.spi;

import dev.conductor.centra.domain.userAssociation.entity.UserAssociation;

import java.util.List;

public interface UserAssociationPersistencePort {

    UserAssociation create(UserAssociation association);
    UserAssociation update(UserAssociation association);
    void delete(UserAssociation association);
    List<UserAssociation> findBySource(String associationType, String sourceNodeId);
    List<UserAssociation> findBySink(String associationType, String sinkNodeEntity, String sinkNodeId);
}
