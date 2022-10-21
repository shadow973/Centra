package dev.conductor.centra.domain.issue.api.impl;

import dev.conductor.centra.domain.issue.api.IssuePrioritySchemaService;
import dev.conductor.centra.domain.issue.entity.IssuePriority;
import dev.conductor.centra.domain.issue.entity.IssuePrioritySchema;
import dev.conductor.centra.domain.issue.spi.IssuePriorityPersistencePort;
import dev.conductor.centra.domain.issue.spi.IssuePrioritySchemaPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssuePrioritySchemaServiceAdapter implements IssuePrioritySchemaService {

    @Autowired
    private IssuePriorityPersistencePort priorityPersistencePort;

    @Autowired
    private IssuePrioritySchemaPersistencePort schemaPersistencePort;


    @Override
    public List<IssuePriority> findAllPriorities() {
        return priorityPersistencePort.findAll();
    }

    @Override
    public IssuePriority findPriorityById(String id) {
        return priorityPersistencePort.findById(id);
    }

    @Override
    public IssuePriority findPriorityByLabel(String label) {
        return priorityPersistencePort.findByLabel(label);
    }

    @Override
    public IssuePriority createPriority(IssuePriority issuePriority) {
        return priorityPersistencePort.create(issuePriority);
    }

    @Override
    public IssuePrioritySchema createSchema(IssuePrioritySchema schema) {
        return schemaPersistencePort.create(schema);
    }

    @Override
    public IssuePrioritySchema findSchemaByName(String name) {
        return schemaPersistencePort.findByName(name);
    }

    @Override
    public IssuePrioritySchema findSchemaById(String id) {
        return schemaPersistencePort.findById(id);
    }

    @Override
    public List<IssuePriority> findPriorityBySchema(IssuePrioritySchema schema) {
        List<IssuePriority> results = new ArrayList<>();

        for (String issueTypeId : schema.getPriorityIds()){
            results.add(findPriorityById(issueTypeId));
        }

        return results;
    }
}
