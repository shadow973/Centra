package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.applicationUser.dto.UserLiteDTO;
import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.api.IssueCommentService;
import dev.conductor.centra.domain.issue.api.IssueService;
import dev.conductor.centra.domain.issue.api.IssueTypeSchemaService;
import dev.conductor.centra.domain.issue.api.IssueWatchService;
import dev.conductor.centra.domain.issue.dto.IssueChangeDTO;
import dev.conductor.centra.domain.issue.dto.IssueCommentDTO;
import dev.conductor.centra.domain.issue.dto.IssueDTO;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.issue.entity.IssueComment;
import dev.conductor.centra.domain.issue.entity.IssueLinks;
import dev.conductor.centra.domain.issue.entity.IssueType;
import dev.conductor.centra.domain.label.api.LabelService;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import dev.conductor.centra.domain.workflow.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/issues")
public class IssueController extends BaseController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IssueCommentService issueCommentService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private IssueTypeSchemaService issueTypeSchemaService;

    @Autowired
    private IssueWatchService issueWatchService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public IssueDTO findById(@PathVariable String id) {
        Issue issue = getIssueByExternalId(id);
        Project project = projectService.findById(issue.getProjectId());

        if (project == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    PROJECT_NOT_FOUND_ERROR_MESSAGE
            );
        }
        return convertToDTO(issue);
    }

    @PostMapping
    public IssueDTO createIssue(@RequestBody IssueDTO issue, Principal principal) {
        Project project = projectService.findByKey(issue.getProjectKey());

        if (project == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,PROJECT_NOT_FOUND_ERROR_MESSAGE);
        }

        ApplicationUser user = applicationUserService.findByUsername(principal.getName());

        if (user == null){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "User not found"
            );
        }

        try {
            return convertToDTO(issueService.createIssue(issue, user));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    e.getMessage()
            );
        }
    }

    @PutMapping("/{id}")
    public IssueDTO updateIssue (
            @RequestBody IssueDTO issueDto,
            @PathVariable String id,
            Principal principal
    ) {
        Issue issue = getIssueByExternalId(id);
        Project project = projectService.findById(issue.getProjectId());

        if (project == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    PROJECT_NOT_FOUND_ERROR_MESSAGE
            );
        }

        Issue entityToSave = Issue.fromIssueDto(issueDto);
        entityToSave.setLastModifiedDate(new Date());
        entityToSave.setLastModifiedByUserId(getAuthenticatedUser(principal).getId());
        issueService.save(entityToSave);

        return convertToDTO(entityToSave);
    }

    @GetMapping(value = "/{id}/comments")
    public List<IssueComment> findCommentsByIssueExternalId(@PathVariable String id) {
        Issue issue = getIssueByExternalId(id);

        return issueCommentService.findByIssueId(issue.getId());
    }

    @PostMapping(value = "/{id}/comments")
    public IssueComment addCommentByExternalId(@RequestBody IssueCommentDTO commentDto, @PathVariable String id, Principal principal) {
        Issue issue = getIssueByExternalId(id);
        ApplicationUser user = applicationUserService.findByUsername(principal.getName());
        return issueCommentService.create(issue, user, commentDto.getText());
    }

    @GetMapping("/{id}/transitions")
    public List<WorkflowTransition> getAvailableIssueTransitions(@PathVariable String id) {
        Issue issue = getIssueByExternalId(id);
        Workflow workflow = workflowService.findById(issue.getWorkflowId());

        if (workflow == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Workflow not found."
            );
        }

        return workflowService.getAvailableTransitions(workflow, issue.getWorkflowState());
    }

    @PostMapping("/{id}/transitions")
    public IssueDTO applyWorkflowTransition(
            @RequestBody WorkflowTransition transition,
            @PathVariable String id,
            Principal principal
    ) {
        Issue issue = getIssueByExternalId(id);

        try {
            ApplicationUser user = applicationUserService.findByUsername(principal.getName());
            workflowService.transitionIssue(issue, transition, user);

            return convertToDTO(issue);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    e.getMessage()
            );
        }
    }

    @GetMapping("/labels")
    public List<String> regexSearchLabels(){
        return labelService.findAll();
    }

    @GetMapping("/{id}/changes")
    public List<IssueChangeDTO> getAuditForIssue(@PathVariable String id) {
        Issue issue = getIssueByExternalId(id);
        return issueService.getAuditLogsForIssue(issue);
    }

    @GetMapping("/{id}/links")
    public List<IssueLinks> getLinksForIssue(@PathVariable String id) {
        Issue issue = getIssueByExternalId(id);
        return issueService.getLinksForIssueByExternalId(buildExternalKeyFromIssue(issue));
    }

    @PostMapping("/links")
    public IssueLinks createIssueLink(@RequestBody IssueLinks link) {
        getIssueByExternalId(link.getLinkPublicId());
        getIssueByExternalId(link.getNodePublicId());

        if (link.getLinkPublicId().equals(link.getNodePublicId())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "You cannot link an issue to itself.");
        }

        return issueService.createIssuelinks(link);
    }

    @DeleteMapping("/links/{id}")
    public void deleteIssueLink(@PathVariable String id){
        IssueLinks link = issueService.findLinkById(id);

        if (link != null){
            issueService.deleteIssueLink(link);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue Link not found");
        }
    }

    @GetMapping("/types/{id}")
    public IssueType getIssueTypeById(@PathVariable String id) {
        return issueTypeSchemaService.findTypeById(id);
    }

    @PostMapping("/{id}/move/{newProjectId}")
    public IssueDTO moveProject(@PathVariable String id, @PathVariable String newProjectId){
        Issue issue = getIssueByExternalId(id);
        Project project = projectService.findById(newProjectId);

        if (project == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }

        return convertToDTO(issueService.move(issue, project));
    }

    @GetMapping("/{id}/watchers")
    public List<UserLiteDTO> getIssueWatchers(@PathVariable String id) {
        Issue issue = getIssueByExternalId(id);

        return issueWatchService.getApplicationUsersWatchingIssue(issue)
                .stream()
                .map(applicationUser -> new UserLiteDTO(
                        applicationUser.getId(),
                        applicationUser.getDisplayName(),
                        applicationUser.getUsername(),
                        applicationUserService.isAdmin(applicationUser))
                ).collect(Collectors.toList());
    }

    @PutMapping("/{id}/watchers/{username}")
    public List<UserLiteDTO> addIssueWatcher(@PathVariable String id, @PathVariable String username) {
        final Issue issue = getIssueByExternalId(id);

        ApplicationUser user = applicationUserService.findByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        issueWatchService.watchIssue(user, issue);

        return getIssueWatchers(id);
    }

    @DeleteMapping("/{id}/watchers/{username}")
    public List<UserLiteDTO> deleteWatcher(@PathVariable String id, @PathVariable String username) {
        final Issue issue = getIssueByExternalId(id);

        ApplicationUser user = applicationUserService.findByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        issueWatchService.unwatchIssue(user, issue);
        return getIssueWatchers(id);
    }
    
    private IssueDTO convertToDTO(Issue issue) {
        IssueDTO dto = modelMapper.map(issue, IssueDTO.class);
        dto.setProjectKey(projectService.findById(issue.getProjectId()).getProjectKey());

        return dto;
    }
}
