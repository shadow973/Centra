package dev.conductor.centra.domain.issue.api.impl;

import dev.conductor.centra.domain.customField.api.CustomFieldService;
import dev.conductor.centra.domain.issue.api.IssueService;
import dev.conductor.centra.domain.issue.dto.IssueChangeDTO;
import dev.conductor.centra.domain.issue.dto.IssueDTO;
import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.issue.entity.IssueLinks;
import dev.conductor.centra.domain.issue.spi.IssueLinksPersistencePort;
import dev.conductor.centra.domain.issue.spi.IssuePersistencePort;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import dev.conductor.centra.domain.workflow.entities.Workflow;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueEntity;
import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import org.javers.core.diff.Change;
import org.javers.core.diff.changetype.PropertyChange;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.diff.changetype.container.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IssueServiceAdapter implements IssueService {

    @Autowired
    private IssuePersistencePort persistencePort;

    @Autowired
    private ApplicationUserService userService;

    @Autowired
    private IssueLinksPersistencePort issueLinksPersistencePort;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private CustomFieldService customFieldService;

    @Autowired
    private Javers javers;

    @Override
    public List<Issue> findByProjectId(String project) {
        return persistencePort.findByProjectId(project);
    }

    @Override
    public Issue findByProjectIdAndExternalId(String projectId, long externalId) {
        return persistencePort.findByProjectIdAndExternalId(projectId, externalId);
    }

    @Override
    public Issue save(Issue issue) {
        issue.setLastModifiedDate(new Date());
        return persistencePort.save(issue);
    }

    @Override
    public synchronized long getNextExternalIdByProject(String projectId) {
        Project project = projectService.findById(projectId);

        long counter = 1;

        if (project.getCounter() > 0) {
            counter = project.getCounter() + 1;
        }

        project.setCounter(counter);
        projectService.save(project);
        return counter;
    }

    public List<IssueChangeDTO> getAuditLogsForIssue(Issue issue) {
        List<IssueChangeDTO> results = new ArrayList<>();

        javers.findChanges(
            QueryBuilder
                    .byInstanceId(issue.getId(), IssueEntity.class)
                    .withChildValueObjects()
                    .build()
        ).forEach(change -> {
            ApplicationUser author = userService
                    .findByUsername(change.getCommitMetadata().get().getAuthor());

            results.add(new IssueChangeDTO(
                    author.getId(),
                    change.getCommitMetadata().get().getCommitDate(),
                    getPropertyNameWithPath(change),
                    getRight(change),
                    getLeft(change)

            ));
        });

        return results;
    }

    @Override
    public void deleteIssue(Issue issue) {
        persistencePort.delete(issue);
    }

    @Override
    public IssueLinks createIssuelinks(IssueLinks issueLinks) {
        return issueLinksPersistencePort.create(issueLinks);
    }

    @Override
    public List<IssueLinks> getLinksForIssueByExternalId(String externalId) {
        List<IssueLinks> links = issueLinksPersistencePort.findByLinkPublicId(externalId);
        links.addAll(issueLinksPersistencePort.findByNodePublicId(externalId));

        return links;
    }

    @Override
    public IssueLinks findLinkById(String id) {
        return issueLinksPersistencePort.findById(id);
    }

    @Override
    public void deleteIssueLink(IssueLinks issueLinks) {
        issueLinksPersistencePort.delete(issueLinks);
    }

    @Override
    public Issue createIssue(IssueDTO issueDTO, ApplicationUser user) {
        Project project = projectService.findByKey(issueDTO.getProjectKey());

        if (project == null) {
            throw new RuntimeException("Project not found to create issue");
        }

        Workflow workflow = workflowService.findById(project.getWorkflowId());

        if (workflow == null) {
            throw new RuntimeException(
                    "Workflow not found or belongs to a different project"
            );
        }

        Issue entity = new Issue(
                getNextExternalIdByProject(project.getId()),
                issueDTO.getTitle(),
                issueDTO.getDescription(),
                project.getId(),
                new Date(),
                new Date(),
                workflowService.getInitialState(workflow),
                project.getWorkflowId(),
                user.getId(),
                issueDTO.getAssigneeId(),
                user.getId(),
                issueDTO.getIssuePriorityId(),
                issueDTO.getIssueTypeId(),
                (issueDTO.getLabels() != null) ? issueDTO.getLabels() : new ArrayList<>()
            );

        Issue savedIssue = save(entity);

        customFieldService.createDefaultCustomFieldValuesForIssue(savedIssue);

        return savedIssue;
    }

    @Override
    public Issue move(Issue issue, Project toProject) {
        long newId = getNextExternalIdByProject(toProject.getId());
        Project oldProject = projectService.findById(issue.getProjectId());
        String oldExternalId = oldProject.getProjectKey() + "-" + issue.getExternalId();
        String newExternalId = toProject.getProjectKey() + "-" + newId;

        this.getLinksForIssueByExternalId(oldExternalId).forEach(issueLinks -> {
                IssueLinks newLink = new IssueLinks();
                if (issueLinks.getLinkPublicId().equals(oldExternalId)){
                    newLink.setLinkPublicId(newExternalId);
                    newLink.setNodePublicId(issueLinks.getNodePublicId());
                } else {
                    newLink.setNodePublicId(newExternalId);
                    newLink.setLinkPublicId(issueLinks.getLinkPublicId());
                }

                createIssuelinks(newLink);
                deleteIssueLink(issueLinks);
            });

        issue.setExternalId(newId);
        issue.setProjectId(toProject.getId());
        return save(issue);
    }

    private String getPropertyNameWithPath(Change change) {
        if (change instanceof PropertyChange) {
            return ((PropertyChange) change).getPropertyNameWithPath().replace(".", ":");
        }

        if (change instanceof ValueChange) {
            return ((ValueChange) change).getPropertyNameWithPath().replace(".", ":");
        }

        return "";
    }

    private Object getRight(Change change) {
        if (change instanceof ValueChange){
            return ((ValueChange) change).getRight();
        }

        if (change instanceof ListChange) {
            ContainerElementChange ce = ((ListChange) change).getChanges().get(0);

            if (ce instanceof ValueAdded) {
                return "Added: " + ((ValueAdded) ce).getValue();
            } else if (ce instanceof ValueRemoved) {
                return "Removed: " + ((ValueRemoved) ce).getValue();
            } else if (ce instanceof ElementValueChange) {
                return "Changed: " + ((ElementValueChange) ce).getRightValue();
            }
        }

        return null;
    }

    private Object getLeft(Change change) {
        if (change instanceof ValueChange){
            return ((ValueChange) change).getLeft();
        }

        if (change instanceof ListChange) {
            ContainerElementChange ce = ((ListChange) change).getChanges().get(0);

            if (ce instanceof ValueAdded) {
                return "Added: " + ((ValueAdded) ce).getValue();
            } else if (ce instanceof ValueRemoved) {
                return "Removed: " + ((ValueRemoved) ce).getValue();
            } else if (ce instanceof ElementValueChange) {
                return "Changed: " + ((ElementValueChange) ce).getLeftValue();
            }
        }

        return null;
    }
}
