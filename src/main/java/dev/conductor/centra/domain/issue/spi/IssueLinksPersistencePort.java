package dev.conductor.centra.domain.issue.spi;

import dev.conductor.centra.domain.issue.entity.IssueLinks;

import java.util.List;

public interface IssueLinksPersistencePort {
    List<IssueLinks> findByNodePublicId(String id);
    List<IssueLinks> findByLinkPublicId(String id);
    IssueLinks findById(String id);
    void delete(IssueLinks issueLinks);
    IssueLinks create(IssueLinks issueLinks);
}
