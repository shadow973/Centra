package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.IssueTypeSchema;


public interface IssueTypeSchemaPersistencePort {

    IssueTypeSchema findByName(String name);
    IssueTypeSchema findById(String id);
    IssueTypeSchema create(IssueTypeSchema schema);
}
