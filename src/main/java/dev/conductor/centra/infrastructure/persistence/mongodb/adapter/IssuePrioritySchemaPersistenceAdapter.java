package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.IssuePrioritySchema;
import dev.conductor.centra.domain.issue.spi.IssuePrioritySchemaPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssuePrioritySchemaEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssuePrioritySchemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;

@Repository
public class IssuePrioritySchemaPersistenceAdapter implements IssuePrioritySchemaPersistencePort {

    private final IssuePrioritySchemaRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssuePrioritySchemaPersistenceAdapter(IssuePrioritySchemaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssuePrioritySchema findById(String id) {
        Optional<IssuePrioritySchemaEntity> entity = repository.findById(id);

        return entity.map(
                    issuePrioritySchemaEntity -> modelMapper.map(issuePrioritySchemaEntity, IssuePrioritySchema.class)
                ).orElse(null);
    }

    @Override
    public IssuePrioritySchema findByName(String name) {
        return modelMapper.map(repository.findByName(name), IssuePrioritySchema.class);
    }

    @Override
    public IssuePrioritySchema create(IssuePrioritySchema schema) {
        return modelMapper.map(
                repository.save(
                        modelMapper.map(schema, IssuePrioritySchemaEntity.class)
                ),
                IssuePrioritySchema.class
        );
    }
}
