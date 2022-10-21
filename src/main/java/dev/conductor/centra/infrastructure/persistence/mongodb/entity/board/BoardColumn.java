package dev.conductor.centra.infrastructure.persistence.mongodb.entity.board;

import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardColumn {
    private String label;
    private Integer order;
    private List<WorkflowState> workflowStates;
    private Integer minIssues;
    private Integer maxIssues;
}
