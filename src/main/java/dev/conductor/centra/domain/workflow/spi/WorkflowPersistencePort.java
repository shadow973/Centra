package dev.conductor.centra.domain.workflow.spi;

import dev.conductor.centra.domain.workflow.entities.Workflow;

import java.util.List;

public interface WorkflowPersistencePort {

    List<Workflow> findAll();
    Workflow findByName(String name);
    Workflow findById(String id);
    Workflow save(Workflow workflow);
}
