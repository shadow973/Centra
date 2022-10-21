package dev.conductor.centra.domain.workflow.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class WorkflowState implements Serializable {

    private boolean isEntry;
    private boolean isTerminus;
    private String label;

    public WorkflowState(boolean isEntry, boolean isTerminus, String label) {
        this.isEntry = isEntry;
        this.isTerminus = isTerminus;
        this.label = label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEntry, isTerminus, label);
    }
}
