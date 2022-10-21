package dev.conductor.centra.domain.issue.api;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.dto.IssueChangeDTO;
import dev.conductor.centra.domain.issue.dto.IssueDTO;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.issue.entity.IssueLinks;
import dev.conductor.centra.domain.project.entity.Project;

import java.util.List;

public interface IssueService {

    List<Issue> findByProjectId(String projectId);
    Issue findByProjectIdAndExternalId(String projectId, long externalId);
    Issue save(Issue issue);
    long getNextExternalIdByProject(String projectId);
    List<IssueChangeDTO> getAuditLogsForIssue(Issue issue);
    void deleteIssue(Issue issue);
    IssueLinks createIssuelinks(IssueLinks issueLinks);
    List<IssueLinks> getLinksForIssueByExternalId(String externalId);
    IssueLinks findLinkById(String id);
    void deleteIssueLink(IssueLinks issueLinks);
    Issue createIssue(IssueDTO issueDTO, ApplicationUser user);
    Issue move(Issue issue, Project toProject);
}
