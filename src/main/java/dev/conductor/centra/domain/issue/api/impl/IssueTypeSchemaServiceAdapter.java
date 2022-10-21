package dev.conductor.centra.domain.issue.api.impl;

import dev.conductor.centra.domain.issue.api.IssueTypeSchemaService;
import dev.conductor.centra.domain.issue.entity.IssueType;
import dev.conductor.centra.domain.issue.entity.IssueTypeSchema;
import dev.conductor.centra.domain.issue.spi.IssueTypePersistencePort;
import dev.conductor.centra.domain.issue.spi.IssueTypeSchemaPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueTypeSchemaServiceAdapter implements IssueTypeSchemaService {

    @Autowired
    private IssueTypePersistencePort typePersistencePort;

    @Autowired
    private IssueTypeSchemaPersistencePort schemaPersistencePort;

    @Override
    public List<IssueType> findAllTypes() {
        return typePersistencePort.findAll();
    }

    @Override
    public IssueType findTypeById(String id) {
        return typePersistencePort.findById(id);
    }

    @Override
    public IssueType findTypeByLabel(String label) {
        return typePersistencePort.findByLabel(label);
    }

    @Override
    public IssueType createType(IssueType issueType) {
        return typePersistencePort.create(issueType);
    }

    @Override
    public IssueTypeSchema createSchema(IssueTypeSchema schema) {
        return schemaPersistencePort.create(schema);
    }

    @Override
    public IssueTypeSchema findSchemaByName(String name) {
        return schemaPersistencePort.findByName(name);
    }

    @Override
    public IssueTypeSchema findSchemaById(String id) {
        return schemaPersistencePort.findById(id);
    }

    @Override
    public List<IssueType> findTypeBySchema(IssueTypeSchema schema) {
        return schema.getIssueTypeIds().stream().map(this::findTypeById).toList();
    }
}
