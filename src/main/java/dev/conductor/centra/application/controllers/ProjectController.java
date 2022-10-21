package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.issue.entity.IssuePriority;
import dev.conductor.centra.domain.issue.entity.IssueType;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.issue.api.IssuePrioritySchemaService;
import dev.conductor.centra.domain.issue.api.IssueTypeSchemaService;
import dev.conductor.centra.domain.project.api.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController extends BaseController {

    @Autowired
    ProjectService projectService;

    @Autowired
    IssueTypeSchemaService issueTypeSchemaService;

    @Autowired
    IssuePrioritySchemaService prioritySchemaService;

    @GetMapping
    public List<Project> listAll() {
        List<Project> projects = projectService.listAll();
        return projects;
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable String id) {
        return projectService.findById(id);
    }

    @PostMapping
    public Project createProject (@RequestBody Project project, Principal principal) {
        if (!this.isAdmin(principal)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Not an administrator"
            );
        }


        if (projectService.findByKey(project.getProjectKey()) != null) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "Project with key already exists"
            );
        }

        return projectService.create(project);
    }

    @PostMapping("/{id}")
    public Project saveProject(@PathVariable String id, @RequestBody Project project, Principal principal) {
        if (project == null || !id.equals(project.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (!this.isAdmin(principal)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Not an administrator"
            );
        }

        if (projectService.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return projectService.save(project);
    }

    @GetMapping("/{id}/issueTypes")
    public List<IssueType> getIssueTypesForProject(@PathVariable String id) {
        Project project = null;
        Project optionalProject = projectService.findById(id);

        if (optionalProject == null){
            project = projectService.findByKey(id);
        }

        if (optionalProject == null && project == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Project was not found"
            );
        }

        String issueTypeSchemaId = (project != null) ? project.getIssueTypeSchemaId()
                : optionalProject.getIssueTypeSchemaId();

        return issueTypeSchemaService.findTypeBySchema(
                issueTypeSchemaService.findSchemaById(issueTypeSchemaId)
        );
    }

    @GetMapping("/{id}/priorities")
    public List<IssuePriority> getPrioritiesForProject(@PathVariable String id) {
        Project project = null;
        Project optionalProject = projectService.findById(id);

        if (optionalProject == null){
            project = projectService.findByKey(id);
        }

        if (optionalProject == null && project == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Project was not found"
            );
        }

        String prioritySchemaId = (project != null) ? project.getPrioritySchemaId()
                : optionalProject.getPrioritySchemaId();

        return prioritySchemaService.findPriorityBySchema(
                prioritySchemaService.findSchemaById(prioritySchemaId)
        );
    }

    @GetMapping("/priorities/{id}")
    public IssuePriority getPriorityById(@PathVariable String id) {
        return prioritySchemaService.findPriorityById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteIssuesAndProject(@PathVariable String id, Principal principal) {
        if (!this.isAdmin(principal)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Not an administrator"
            );
        }
        Project optionalProject = projectService.findById(id);

        if (optionalProject == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Project was not found"
            );
        }

        this.projectService.delete(optionalProject);
    }
}
