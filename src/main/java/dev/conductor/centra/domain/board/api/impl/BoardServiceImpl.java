package dev.conductor.centra.domain.board.api.impl;

import dev.conductor.centra.domain.board.api.BoardService;
import dev.conductor.centra.domain.board.dto.CreateBoardDto;
import dev.conductor.centra.domain.board.entity.Board;
import dev.conductor.centra.domain.board.entity.BoardColumn;
import dev.conductor.centra.domain.board.enums.BoardType;
import dev.conductor.centra.domain.board.spi.BoardPersistencePort;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import dev.conductor.centra.domain.workflow.entities.Workflow;
import dev.conductor.centra.domain.workflow.entities.WorkflowState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final ProjectService projectService;
    private final WorkflowService workflowService;
    private final BoardPersistencePort persistence;

    @Autowired
    public BoardServiceImpl(ProjectService projectService, WorkflowService workflowService, BoardPersistencePort persistence) {
        this.projectService = projectService;
        this.workflowService = workflowService;
        this.persistence = persistence;
    }

    @Override
    public Board getById(String id) {
        return persistence.findById(id);
    }

    public List<Board> findAll() {
        return persistence.findAll();
    }

    @Override
    public Board createBoardFromDto(CreateBoardDto dto) {
        if (dto.getType().equals(BoardType.KANBAN)){
            return createDefaultKanbanBoard(dto);
        }

        if (dto.getType().equals(BoardType.SCRUM)){
            return createDefaultKanbanBoard(dto);
        }

        throw new RuntimeException("Unknown board type");
    }

    private Board createDefaultKanbanBoard(CreateBoardDto dto) {
        Board board = new Board();
        board.setName(dto.getName());
        board.setType(BoardType.KANBAN);
        board.setProjectIds(dto.getProjectIds());
        board.setCql(generateCqlStringFromProjects(dto.getProjectIds()));

        List<WorkflowState> workflowStates = new ArrayList<>();

        dto.getProjectIds().forEach(projectId -> {
            Project project = projectService.findById(projectId);
            Workflow workflow = workflowService.findById(project.getWorkflowId());

            workflow.getStates().forEach(workflowState -> {
                if (!workflowStates.contains(workflowState)){
                    workflowStates.add(workflowState);
                }
            });
        });


        List<WorkflowState> todoStates = workflowStates.stream()
                .filter(workflowState -> !workflowState.isTerminus() && workflowState.isEntry())
                .collect(Collectors.toList());

        BoardColumn todoColumn = new BoardColumn();
        todoColumn.setWorkflowStates(todoStates);
        todoColumn.setLabel("To Do");
        todoColumn.setOrder(0);

        board.getBoardColumns().add(todoColumn);

        List<WorkflowState> inProgressStates = workflowStates.stream()
                .filter(workflowState -> !workflowState.isTerminus() && !workflowState.isEntry())
                .collect(Collectors.toList());

        BoardColumn inProgressColumn = new BoardColumn();
        inProgressColumn.setWorkflowStates(inProgressStates);
        inProgressColumn.setLabel("In Progress");
        inProgressColumn.setOrder(1);

        board.getBoardColumns().add(inProgressColumn);

        List<WorkflowState> doneStates = workflowStates.stream()
                .filter(workflowState -> workflowState.isTerminus() && !workflowState.isEntry())
                .collect(Collectors.toList());

        BoardColumn doneColumn = new BoardColumn();
        doneColumn.setWorkflowStates(doneStates);
        doneColumn.setLabel("Done");
        doneColumn.setOrder(2);

        board.getBoardColumns().add(doneColumn);

        return persistence.save(board);
    }

    private String generateCqlStringFromProjects(List<String> projectIds) {
        List<String> projectKeys = projectIds.stream()
                .map(projectService::findById)
                .map(Project::getProjectKey)
                .collect(Collectors.toList());

        return "projectKey IN ("+ String.join(",", projectKeys) +") AND updated >= -2w";
    }
}
