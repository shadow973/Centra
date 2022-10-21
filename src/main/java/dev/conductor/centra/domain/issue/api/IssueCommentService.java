package dev.conductor.centra.domain.issue.api;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.issue.entity.IssueComment;

import java.util.List;

public interface IssueCommentService {

    List<IssueComment> findByIssueId(String issueId);
    IssueComment create(Issue issue, ApplicationUser user, String text);
}
