package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.Issue;

import java.util.List;

public interface IssuePersistencePort {

    List<Issue> findByProjectId (String projectId);
    Issue findByProjectIdAndExternalId(String projectId, long externalId);
    Issue save(Issue issue);
    void delete(Issue issue);
}
