package dev.conductor.centra.domain.project.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Project implements Serializable {

    public static String DEFAULT_ISSUE_TYPE_SCHEMA_NAME = "Default Issue Type Schema";
    public static String DEFAULT_WORKFLOW_NAME = "Default Workflow";
    public static String DEFAULT_PRIORITY_SCHEMA_NAME = "Default Priority Schema";

    private String id;
    private String projectKey;
    private String projectName;
    private String description;
    private String workflowId;
    private String issueTypeSchemaId;
    private String prioritySchemaId;
    private long counter;

    public Project() {}

    public Project(String projectKey, String projectName, String description, String workflowId, String issueTypeSchemaId, String prioritySchemaId) {
        this.projectKey = projectKey;
        this.projectName = projectName;
        this.description = description;
        this.workflowId = workflowId;
        this.issueTypeSchemaId = issueTypeSchemaId;
        this.prioritySchemaId = prioritySchemaId;
        this.counter = 0;
    }
}
