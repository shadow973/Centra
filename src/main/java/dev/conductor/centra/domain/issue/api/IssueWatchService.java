package dev.conductor.centra.domain.issue.api;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.entity.Issue;

import java.util.List;

public interface IssueWatchService {
    String ASSOCIATION_TYPE = "WatchIssue";
    String SINK_ENTITY_NAME = "Issue";

    void watchIssue(ApplicationUser user, Issue issue);
    void unwatchIssue(ApplicationUser user, Issue issue);
    List<ApplicationUser> getApplicationUsersWatchingIssue(Issue issue);
}
