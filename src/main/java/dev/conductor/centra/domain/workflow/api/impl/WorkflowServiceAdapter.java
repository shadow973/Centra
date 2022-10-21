package dev.conductor.centra.domain.workflow.api.impl;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.spi.IssuePersistencePort;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.workflow.entities.Workflow;
import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import dev.conductor.centra.domain.workflow.entities.WorkflowTransition;
import dev.conductor.centra.domain.workflow.spi.WorkflowPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkflowServiceAdapter implements WorkflowService {

    @Autowired
    private WorkflowPersistencePort persistencePort;

    @Autowired
    private IssuePersistencePort issuePersistencePort;

    @Override
    public List<Workflow> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Workflow create(Workflow workflow) {
        return persistencePort.save(workflow);
    }

    @Override
    public Workflow save(Workflow workflow) {
        return persistencePort.save(workflow);
    }

    @Override
    public Workflow findById(String id) {
        return persistencePort.findById(id);
    }

    @Override
    public Workflow findByName(String name) {
        return persistencePort.findByName(name);
    }

    @Override
    public WorkflowState getInitialState(Workflow workflow) {
        return workflow.getStates().stream()
                .filter(WorkflowState::isEntry)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Initial state could not be found for workflow"));
    }

    public List<WorkflowTransition> getAvailableTransitions(Workflow workflow, WorkflowState currentState) {
        return workflow.getTransitions().stream()
                .filter(e -> e.getFromNode().equals(currentState.getLabel()))
                .toList();
    }

    @Override
    public Issue transitionIssue(Issue issue, WorkflowTransition transition, ApplicationUser user) {
        Workflow workflow = findById(issue.getWorkflowId());

        if (workflow == null) {
            throw new IllegalArgumentException("Workflow doesn't exist");
        }

        if(!getAvailableTransitions(workflow, issue.getWorkflowState()).contains(transition)){
            throw new IllegalStateException("Transition not available or valid");
        }

        WorkflowState state = workflow.getStates().stream()
                .filter(e -> e.getLabel().equals(transition.getToNode()))
                .findFirst()
                .orElse(workflow.getStates().get(0));

        issue.setWorkflowState(state);
        issue.setLastModifiedDate(new Date());
        issue.setLastModifiedByUserId(user.getId());

        issuePersistencePort.save(issue);

        return issue;
    }
}
