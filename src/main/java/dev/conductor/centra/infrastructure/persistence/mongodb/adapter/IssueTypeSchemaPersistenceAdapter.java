package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.IssueTypeSchema;
import dev.conductor.centra.domain.issue.spi.IssueTypeSchemaPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueTypeSchemaEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssueTypeSchemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;

@Repository
public class IssueTypeSchemaPersistenceAdapter implements IssueTypeSchemaPersistencePort {

    private final IssueTypeSchemaRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueTypeSchemaPersistenceAdapter(IssueTypeSchemaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueTypeSchema findByName(String name) {
        return modelMapper.map(repository.findByName(name), IssueTypeSchema.class);
    }

    @Override
    public IssueTypeSchema findById(String id) {
        return repository.findById(id).map(
                    issueTypeSchema -> modelMapper.map(issueTypeSchema, IssueTypeSchema.class)
                ).orElse(null);
    }

    @Override
    @CachePut(value = "issueTypeSchema", key = "#schema.id", condition="#schema.id != null")
    public IssueTypeSchema create(IssueTypeSchema schema) {
        return modelMapper.map(repository.save(modelMapper.map(schema, IssueTypeSchemaEntity.class)), IssueTypeSchema.class);
    }
}
