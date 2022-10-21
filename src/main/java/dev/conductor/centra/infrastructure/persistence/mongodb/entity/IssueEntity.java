package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import lombok.Getter;
import lombok.Setter;
import org.javers.core.metamodel.annotation.DiffIgnore;
import org.javers.core.metamodel.annotation.DiffInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@CompoundIndexes({
        @CompoundIndex(name = "issue_externalid_projectid", def = "{'externalId' : 1, 'projectId': 1}")
})
@Document(collection = "issues")
public class IssueEntity {

    @Id private String id;
    @DiffInclude private long externalId;
    @DiffInclude private String projectId;
    @DiffInclude @TextIndexed private String title;
    @DiffInclude @TextIndexed private String description;
    @DiffInclude private Date createdDate;
    @DiffIgnore private Date lastModifiedDate;
    @DiffInclude private String workflowId;
    @DiffInclude private WorkflowState workflowState;
    @DiffInclude private String createdByUserId;
    @DiffInclude private List<String> assigneeId;
    @DiffInclude private String lastModifiedByUserId;
    @DiffInclude private String issuePriorityId;
    @DiffInclude private String issueTypeId;
    @DiffInclude @Indexed private List<String> labels;

}
