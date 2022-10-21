package dev.conductor.centra.domain.issue.entity;

import dev.conductor.centra.domain.issue.dto.IssueDTO;
import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Issue implements Serializable {

    private String id;
    private long externalId;
    private String projectId;
    private String title;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;
    private String workflowId;
    private WorkflowState workflowState;
    private String createdByUserId;
    private List<String> assigneeId;
    private String lastModifiedByUserId;
    private String issuePriorityId;
    private String issueTypeId;
    private List<String> labels;

    public Issue() {}

    public Issue(
            long externalId,
            String title,
            String description,
            String projectId,
            Date createdDate,
            Date lastModifiedDate,
            WorkflowState workflowState,
            String workflowId,
            String createdByUserId,
            List<String> assigneeId,
            String lastModifiedByUserId,
            String issuePriorityId,
            String issueTypeId, List<String> labels
    ) {
        this.externalId = externalId;
        this.title = title;
        this.description = description;
        this.projectId = projectId;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.workflowState = workflowState;
        this.workflowId = workflowId;
        this.createdByUserId = createdByUserId;
        this.assigneeId = assigneeId;
        this.lastModifiedByUserId = lastModifiedByUserId;
        this.issuePriorityId = issuePriorityId;
        this.issueTypeId = issueTypeId;
        this.labels = labels;
    }

    protected Issue(
            String id,
            long externalId,
            String title,
            String description,
            String projectId,
            Date createdDate,
            Date lastModifiedDate,
            WorkflowState workflowState,
            String workflowId,
            String createdByUserId,
            List<String> assigneeId,
            String lastModifiedByUserId,
            String issuePriorityId,
            String issueTypeId,
            List<String> labels
    ) {
        this.id = id;
        this.externalId = externalId;
        this.title = title;
        this.description = description;
        this.projectId = projectId;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.workflowState = workflowState;
        this.workflowId = workflowId;
        this.createdByUserId = createdByUserId;
        this.assigneeId = assigneeId;
        this.lastModifiedByUserId = lastModifiedByUserId;
        this.issuePriorityId = issuePriorityId;
        this.issueTypeId = issueTypeId;
        this.labels = labels;
    }

    public static Issue fromIssueDto(IssueDTO issueDTO) {
        return new Issue(
            issueDTO.getId(),
            issueDTO.getExternalId(),
            issueDTO.getTitle(),
            issueDTO.getDescription(),
            issueDTO.getProjectId(),
            issueDTO.getCreatedDate(),
            issueDTO.getLastModifiedDate(),
            issueDTO.getWorkflowState(),
            issueDTO.getWorkflowId(),
            issueDTO.getCreatedByUserId(),
            issueDTO.getAssigneeId(),
            issueDTO.getLastModifiedByUserId(),
            issueDTO.getIssuePriorityId(),
            issueDTO.getIssueTypeId(),
            issueDTO.getLabels()
        );
    }
}
