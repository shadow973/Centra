package dev.conductor.centra.domain.workflow.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Workflow implements Serializable {

    private String id;
    private String name;
    private List<WorkflowState> states;
    private List<WorkflowTransition> transitions;

    public Workflow(){}

    public Workflow(String name, List<WorkflowState> states, List<WorkflowTransition> transitions) {
        this.name = name;
        this.states = states;
        this.transitions = transitions;
    }
}
