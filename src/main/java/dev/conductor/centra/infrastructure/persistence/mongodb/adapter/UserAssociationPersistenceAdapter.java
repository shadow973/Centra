package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.userAssociation.entity.UserAssociation;
import dev.conductor.centra.domain.userAssociation.spi.UserAssociationPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.UserAssociationEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.UserAssociationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserAssociationPersistenceAdapter implements UserAssociationPersistencePort {

    private final UserAssociationRepository repository;
    private final ModelMapper modelMapper;

    public UserAssociationPersistenceAdapter(UserAssociationRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserAssociation create(UserAssociation association) {
        return modelMapper.map(repository.save(modelMapper.map(association, UserAssociationEntity.class)), UserAssociation.class);
    }

    @Override
    public UserAssociation update(UserAssociation association) {
        return modelMapper.map(repository.save(modelMapper.map(association, UserAssociationEntity.class)), UserAssociation.class);
    }

    @Override
    public void delete(UserAssociation association) {
        repository.delete(modelMapper.map(association, UserAssociationEntity.class));
    }

    @Override
    public List<UserAssociation> findBySource(String associationType, String sourceNodeId) {
        return repository.findByAssociationTypeAndSourceId(associationType, sourceNodeId)
                .stream()
                .map(userAssociationEntity -> modelMapper.map(userAssociationEntity, UserAssociation.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAssociation> findBySink(String associationType, String sinkNodeEntity, String sinkNodeId) {
        return repository.findByAssociationTypeAndSinkNodeEntityAndSinkId(associationType, sinkNodeEntity, sinkNodeId)
                .stream()
                .map(userAssociationEntity -> modelMapper.map(userAssociationEntity, UserAssociation.class))
                .collect(Collectors.toList());
    }
}
