package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import dev.conductor.centra.domain.workflow.entities.WorkflowTransition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "workflows")
public class WorkflowEntity {

    @Id private String id;
    @Indexed(unique = true)
    private String name;
    private List<WorkflowState> states;
    private List<WorkflowTransition> transitions;
    private List flow;

}
