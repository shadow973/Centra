package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "projects")
public class ProjectEntity {

    @Id private String id;
    @Indexed(unique=true)
    private String projectKey;
    private String projectName;
    private String description;
    private String workflowId;
    private String issueTypeSchemaId;
    private String prioritySchemaId;
    private long counter;
}
