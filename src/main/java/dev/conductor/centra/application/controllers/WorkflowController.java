package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import dev.conductor.centra.domain.workflow.dto.WorkflowDTO;
import dev.conductor.centra.domain.workflow.entities.Workflow;
import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import dev.conductor.centra.domain.workflow.entities.WorkflowTransition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private ProjectService projectService;

    @GetMapping
    List<Workflow> findAll() {
        return workflowService.findAll();
    }

    @PostMapping
    Workflow create(@RequestBody EntityModel<WorkflowDTO> workflowDto) {
        WorkflowDTO dto = workflowDto.getContent();
        assert dto != null;
        Project project = projectService.findById(dto.getProjectId());

        if (project == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "No such project exists"
            );
        }

        List<Workflow> existingWorkflows = workflowService.findAll();

        Workflow wfl = existingWorkflows.stream()
                .filter(e -> e.getName().equals(dto.getName()))
                .findFirst()
                .orElse(null);

        if (wfl != null) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "Duplicate workflow with same name exists"
            );
        }

        Workflow workflow = new Workflow(
                dto.getName(),
                dto.getStates(),
                dto.getTransitions()
        );

        return workflowService.create(workflow);
    }

    @GetMapping("/{id}")
    Workflow getById(@PathVariable String id){
        return workflowService.findById(id);
    }

    @PutMapping("/{id}")
    Workflow save(@PathVariable String id, @RequestBody EntityModel<WorkflowDTO> workflowDto) {
        WorkflowDTO dto = workflowDto.getContent();

        if (dto == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else if(dto.getStates().get(0).getLabel() == null || dto.getTransitions().get(0).getLabel() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else if(dto.getStates().get(0).isEntry() ^ dto.getStates().get(0).isTerminus()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Workflow originalWorkflow = workflowService.findById(id);
        
        List<WorkflowState> originalStates = originalWorkflow.getStates();
        List<WorkflowTransition> originalTransitions = originalWorkflow.getTransitions();
        List<WorkflowState> dtoStates = dto.getStates();
        List<WorkflowTransition> dtoTransitions = dto.getTransitions();

        if(dtoStates.get(0).isEntry() == true) {
            originalStates.add(0, dtoStates.get(0));
            originalStates.get(1).setEntry(false);
            originalTransitions.add(0, dtoTransitions.get(0));
//            originalTransitions.
        } else if (dtoStates.get(0).isTerminus() == true) {
            originalStates.add(originalStates.size(), dtoStates.get(0));
            originalStates.get(originalStates.size()-1).setTerminus(false);
            originalTransitions.add(originalTransitions.size(), dtoTransitions.get(0));
        } else {
            for (int i = 0; i < originalTransitions.size(); i++) {
                if (originalTransitions.get(i).getFromNode().equals(dtoTransitions.get(0).getFromNode())) {
                    originalTransitions.get(i).setFromNode(dtoStates.get(0).getLabel());
                    originalStates.add(i + 1, dtoStates.get(0));
                    dtoTransitions.get(0).setToNode(dtoStates.get(0).getLabel());
                    originalTransitions.add(i + 1, dtoTransitions.get(0));
                }
            }
        }

        Workflow workflow = new Workflow();
        workflow.setId(id);
        workflow.setName(dto.getName() == null ? originalWorkflow.getName() : dto.getName());
        workflow.setStates(originalStates);
        workflow.setTransitions(originalTransitions);

        return workflowService.save(workflow);
    }

    @PutMapping("/{id}/{node}")
    Workflow deleteNode(@PathVariable String id, @PathVariable String node){
        int num1=100, num2=100;
        Workflow originalWorkflow = workflowService.findById(id);
        List<WorkflowState> newState = originalWorkflow.getStates().stream()
                .filter(originalState -> !originalState.getLabel().equals(node))
                .collect(Collectors.toList());
        List<WorkflowTransition> newTransition = originalWorkflow.getTransitions();
        for (int i = 0; i < newTransition.size(); i++) {
            if (newTransition.get(i).getFromNode().equals(node)) {
                num1 = i;
                continue;
            }
            if (newTransition.get(i).getToNode().equals(node)) {
                num2 = i;
                continue;
            }
        }

        if (num1 != 100 && num2 != 100) {
            newTransition.get(num1).setFromNode(newTransition.get(num2).getFromNode());
        }

        newTransition = newTransition.stream()
                .filter(originalTransition -> !node.equals(originalTransition.getToNode()))
                .collect(Collectors.toList());

        Workflow workflow = new Workflow();
        workflow.setId(id);
        workflow.setName(originalWorkflow.getName());
        workflow.setStates(newState);
        workflow.setTransitions(newTransition);
        return workflowService.save(workflow);
    }
}
