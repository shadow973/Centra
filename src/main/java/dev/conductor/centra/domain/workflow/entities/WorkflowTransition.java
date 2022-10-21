package dev.conductor.centra.domain.workflow.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class WorkflowTransition implements Serializable {

    private String fromNode;
    private String toNode;
    private String label;

    public WorkflowTransition(String fromNode, String toNode, String label) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.label = label;
    }

    public String getFromNode() {
        return fromNode;
    }

    public String getToNode() {
        return toNode;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkflowTransition)) return false;
        WorkflowTransition that = (WorkflowTransition) o;
        return Objects.equals(fromNode, that.fromNode) &&
                Objects.equals(toNode, that.toNode) &&
                Objects.equals(label, that.label);
    }
}
