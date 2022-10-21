package dev.conductor.centra.domain.issue.api.impl;

import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.api.IssueWatchService;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.userAssociation.api.UserAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueWatchServiceAdapter implements IssueWatchService {

    private final UserAssociationService userAssociationService;
    private final ApplicationUserService userService;

    @Autowired
    public IssueWatchServiceAdapter(UserAssociationService userAssociationService, ApplicationUserService userService) {
        this.userAssociationService = userAssociationService;
        this.userService = userService;
    }

    @Override
    public void watchIssue(ApplicationUser user, Issue issue) {
        if (!getApplicationUsersWatchingIssue(issue).contains(user)) {
            userAssociationService.createAssociation(
                    IssueWatchService.ASSOCIATION_TYPE,
                    IssueWatchService.SINK_ENTITY_NAME,
                    user.getId(),
                    issue.getId()
            );
        }
    }

    @Override
    public void unwatchIssue(ApplicationUser user, Issue issue) {
        userAssociationService.findAssociationBySink(
                IssueWatchService.ASSOCIATION_TYPE,
                IssueWatchService.SINK_ENTITY_NAME,
                issue.getId()
        ).forEach(association -> {
           if (association.getSourceId().equals(user.getId())){
               userAssociationService.deleteAssociation(association);
           }
        });
    }

    @Override
    public List<ApplicationUser> getApplicationUsersWatchingIssue(Issue issue) {
        return userAssociationService.findAssociationBySink(
                IssueWatchService.ASSOCIATION_TYPE, IssueWatchService.SINK_ENTITY_NAME, issue.getId()
        )
                .stream()
                .map(association -> userService.findById(association.getSourceId()))
                .collect(Collectors.toList());
    }
}
