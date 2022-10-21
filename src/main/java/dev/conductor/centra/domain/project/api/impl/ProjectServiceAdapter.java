package dev.conductor.centra.domain.project.api.impl;

import dev.conductor.centra.domain.issue.api.IssuePrioritySchemaService;
import dev.conductor.centra.domain.issue.api.IssueTypeSchemaService;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.project.spi.ProjectPersistencePort;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceAdapter implements ProjectService {

    @Autowired
    private ProjectPersistencePort persistencePort;

    @Autowired
    IssueTypeSchemaService issueTypeSchemaService;

    @Autowired
    WorkflowService workflowService;

    @Autowired
    IssuePrioritySchemaService issuePrioritySchemaService;

    @Override
    public Project findByKey(String key) {
        return persistencePort.findByProjectKey(key);
    }

    @Override
    public Project create(Project project) {

        if (project.getIssueTypeSchemaId() == null) {
            project.setIssueTypeSchemaId(
                issueTypeSchemaService.findSchemaByName(Project.DEFAULT_ISSUE_TYPE_SCHEMA_NAME).getId()
            );
        }

        if (project.getWorkflowId() == null) {
            project.setWorkflowId(
                workflowService.findByName(Project.DEFAULT_WORKFLOW_NAME).getId()
            );
        }

        if (project.getPrioritySchemaId() == null) {
            project.setPrioritySchemaId(
                    issuePrioritySchemaService.findSchemaByName(Project.DEFAULT_PRIORITY_SCHEMA_NAME).getId()
            );
        }

        return persistencePort.save(project);
    }

    @Override
    public List<Project> listAll() {
        return persistencePort.findAll();
    }

    @Override
    public Project findById(String id) {
        return persistencePort.findById(id);
    }

    @Override
    public Project findByName(String name) {
        return persistencePort.findByProjectName(name);
    }

    @Override
    public void delete(Project project) {
        persistencePort.delete(project);
    }

    @Override
    public Project save(Project project) {
        if (project.getId() == null) {
            throw new RuntimeException("Attempted to save project without valid id");
        }

        return persistencePort.save(project);
    }
}
