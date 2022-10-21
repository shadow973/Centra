package dev.conductor.centra.domain.workflow.dto;

import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import dev.conductor.centra.domain.workflow.entities.WorkflowTransition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorkflowDTO {

    private String projectId;
    private String name;
    private String id;
    private List<WorkflowState> states;
    private List<WorkflowTransition> transitions;
}
