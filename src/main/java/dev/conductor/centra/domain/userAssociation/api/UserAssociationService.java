package dev.conductor.centra.domain.userAssociation.api;

import dev.conductor.centra.domain.userAssociation.entity.UserAssociation;

import java.util.List;

public interface UserAssociationService {
    UserAssociation createAssociation(String associationType, String sinkNodeEntity, String sourceNodeId, String sinkNodeId);
    void deleteAssociation(UserAssociation userAssociation);
    List<UserAssociation> findAssociationBySource(String associationType, String sourceNodeId);
    List<UserAssociation> findAssociationBySink(String associationType, String sinkNodeEntity, String sinkNodeId);
}
