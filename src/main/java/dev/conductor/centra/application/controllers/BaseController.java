package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.issue.api.IssueService;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

abstract class BaseController {

    protected final String PROJECT_NOT_FOUND_ERROR_MESSAGE = "Project not found";

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IssueService issueService;

    protected ApplicationUser getAuthenticatedUser (Principal principal) {
        if (principal == null) {
            return null;
        }

        ApplicationUser user = applicationUserService.findByUsername(principal.getName());

        if (user == null || !user.getEnabled()) {
            return null;
        }

        return user;
    }

    protected Boolean isAdmin(Principal principal) {
        ApplicationUser user = getAuthenticatedUser(principal);
        return user != null && applicationUserService.isAdmin(user);
    }

    protected Issue getIssueByExternalId(String id) {
        String projectKey = id.split("-")[0];
        long externalId = Long.parseLong(id.split("-")[1]);

        Project project = projectService.findByKey(projectKey);

        if (project == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PROJECT_NOT_FOUND_ERROR_MESSAGE);
        }

        Issue issue = issueService.findByProjectIdAndExternalId(project.getId(), externalId);

        if (issue == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue not found");
        }

        return issue;
    }

    protected String buildExternalKeyFromIssue(Issue issue){
        Project projectOptional = projectService.findById(issue.getProjectId());

        if (projectOptional == null) {
            throw new RuntimeException(PROJECT_NOT_FOUND_ERROR_MESSAGE);
        }

        String projectKey = projectOptional.getProjectKey();
        long externalId = issue.getExternalId();
        return projectKey + "-" + externalId;
    }
}
