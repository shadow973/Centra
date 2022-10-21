package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.IssueComment;

import java.util.List;

public interface IssueCommentPersistencePort {
    List<IssueComment> findByIssueIdOrderByCreatedDateAsc(String id);
    IssueComment save(IssueComment comment);
}
