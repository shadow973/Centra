package dev.conductor.centra.domain.userAssociation.api.impl;

import dev.conductor.centra.domain.userAssociation.api.UserAssociationService;
import dev.conductor.centra.domain.userAssociation.entity.UserAssociation;
import dev.conductor.centra.domain.userAssociation.spi.UserAssociationPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAssociationServiceImpl implements UserAssociationService {

    private final UserAssociationPersistencePort persistence;

    @Autowired
    public UserAssociationServiceImpl(UserAssociationPersistencePort persistence) {
        this.persistence = persistence;
    }

    @Override
    public UserAssociation createAssociation(String associationType, String sinkNodeEntity, String sourceNodeId, String sinkNodeId) {
        UserAssociation association = new UserAssociation();
        association.setAssociationType(associationType);
        association.setSourceId(sourceNodeId);
        association.setSinkNodeEntity(sinkNodeEntity);
        association.setSinkId(sinkNodeId);

        return persistence.create(association);
    }

    @Override
    public void deleteAssociation(UserAssociation userAssociation) {
        persistence.delete(userAssociation);
    }

    @Override
    public List<UserAssociation> findAssociationBySource(String associationType, String sourceNodeId) {
        return persistence.findBySource(associationType, sourceNodeId);
    }

    @Override
    public List<UserAssociation> findAssociationBySink(String associationType, String sinkNodeEntity, String sinkNodeId) {
        return persistence.findBySink(associationType, sinkNodeEntity, sinkNodeId);
    }
}
