package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.IssuePriority;

import java.util.List;

public interface IssuePriorityPersistencePort {
    List<IssuePriority> findAll();
    IssuePriority findByLabel(String label);
    IssuePriority findById(String id);
    IssuePriority create(IssuePriority issuePriority);
}
