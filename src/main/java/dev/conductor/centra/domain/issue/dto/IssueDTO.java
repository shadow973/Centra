package dev.conductor.centra.domain.issue.dto;

import dev.conductor.centra.domain.workflow.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class IssueDTO {

    private String id;
    private long externalId;
    private String projectKey;
    private String title;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;
    private String projectId;
    private WorkflowState workflowState;
    private String workflowId;
    private String createdByUserId;
    private List<String> assigneeId;
    private String lastModifiedByUserId;
    private String issuePriorityId;
    private String issueTypeId;
    private List<String> labels;
}
