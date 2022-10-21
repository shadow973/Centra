package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.IssuePrioritySchema;

public interface IssuePrioritySchemaPersistencePort {
    IssuePrioritySchema findById(String id);
    IssuePrioritySchema findByName(String name);
    IssuePrioritySchema create(IssuePrioritySchema schema);
}
