package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.IssueType;

import java.util.List;

public interface IssueTypePersistencePort {

    IssueType findByLabel(String label);
    IssueType findById(String id);
    List<IssueType> findAll();
    IssueType create(IssueType issueType);
}
