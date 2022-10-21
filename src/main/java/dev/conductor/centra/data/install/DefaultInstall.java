package dev.conductor.centra.data.install;

import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.applicationUser.entity.UserGroup;
import dev.conductor.centra.domain.issue.api.IssuePrioritySchemaService;
import dev.conductor.centra.domain.issue.api.IssueTypeSchemaService;
import dev.conductor.centra.domain.issue.entity.IssuePriority;
import dev.conductor.centra.domain.issue.entity.IssuePrioritySchema;
import dev.conductor.centra.domain.issue.entity.IssueType;
import dev.conductor.centra.domain.issue.entity.IssueTypeSchema;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import dev.conductor.centra.domain.workflow.entities.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultInstall {

    private final IssueTypeSchemaService issueTypeSchemaService;
    private final WorkflowService workflowService;
    private final ProjectService projectService;
    private final IssuePrioritySchemaService prioritySchemaService;
    private final ApplicationUserService userService;

    public DefaultInstall(
            IssueTypeSchemaService issueTypeSchemaService,
            WorkflowService workflowService,
            ProjectService projectService,
            IssuePrioritySchemaService prioritySchemaService,
            ApplicationUserService userService
    ) {
        this.issueTypeSchemaService = issueTypeSchemaService;
        this.workflowService = workflowService;
        this.projectService = projectService;
        this.prioritySchemaService = prioritySchemaService;
        this.userService = userService;
    }

    public void createDefaultEntities(){
        createIssueTypeAndSchema();
    }

    protected void createIssueTypeAndSchema(){

        IssueType bug = issueTypeSchemaService.createType(new IssueType( "Bug", "AlertTriangle"));
        IssueType epic = issueTypeSchemaService.createType(new IssueType( "Epic", "Zap"));
        IssueType improvement = issueTypeSchemaService.createType(new IssueType( "Improvement", "ArrowUp"));
        IssueType newFeature = issueTypeSchemaService.createType(new IssueType( "New Feature", "Plus"));
        IssueType story = issueTypeSchemaService.createType(new IssueType("Story", "FileText"));
        IssueType subTask = issueTypeSchemaService.createType(new IssueType( "Sub-task", "Copy"));
        IssueType task = issueTypeSchemaService.createType(new IssueType( "Task", "CheckSquare"));

        IssueTypeSchema schema = new IssueTypeSchema(Project.DEFAULT_ISSUE_TYPE_SCHEMA_NAME);
        schema.addIssueType(bug);
        schema.addIssueType(epic);
        schema.addIssueType(improvement);
        schema.addIssueType(newFeature);
        schema.addIssueType(story);
        schema.addIssueType(subTask);
        schema.addIssueType(task);

        issueTypeSchemaService.createSchema(schema);

        List<WorkflowState> states = new ArrayList<>();

        states.add(new WorkflowState(true, false, "TO DO"));
        states.add(new WorkflowState(false, false, "IN PROGRESS"));
        states.add(new WorkflowState(false, true, "DONE"));

        List<WorkflowTransition> transitions = new ArrayList<>();
        transitions.add(new WorkflowTransition("TO DO", "IN PROGRESS", "In Progress"));
        transitions.add(new WorkflowTransition("IN PROGRESS", "DONE", "Done"));
        transitions.add(new WorkflowTransition("DONE", "TO DO", "Reopen"));

        Workflow wfl = new Workflow(Project.DEFAULT_WORKFLOW_NAME, states, transitions);
        workflowService.create(wfl);

        IssuePriority lowest = prioritySchemaService.createPriority(new IssuePriority("Lowest", "ChevronsDown"));
        IssuePriority low = prioritySchemaService.createPriority(new IssuePriority("Low", "ChevronDown"));
        IssuePriority medium = prioritySchemaService.createPriority(new IssuePriority("Medium", "Code"));
        IssuePriority high = prioritySchemaService.createPriority(new IssuePriority("High", "ChevronUp"));
        IssuePriority highest = prioritySchemaService.createPriority(new IssuePriority("Highest", "ChevronsUp"));

        IssuePrioritySchema prioritySchema = new IssuePrioritySchema();
        prioritySchema.setName(Project.DEFAULT_PRIORITY_SCHEMA_NAME);

        prioritySchema.addPriority(lowest);
        prioritySchema.addPriority(low);
        prioritySchema.addPriority(medium);
        prioritySchema.addPriority(high);
        prioritySchema.addPriority(highest);

        prioritySchemaService.createSchema(prioritySchema);

        projectService.create(new Project(
                "DEMO",
                "Demo",
                "Project to demo features",
                wfl.getId(),
                schema.getId(),
                prioritySchema.getId()
        ));

        setupUserGroups();
    }

    private void setupUserGroups() {
        UserGroup centraUsers = new UserGroup();
        centraUsers.setName(UserGroup.CENTRA_USERS);
        userService.saveGroup(centraUsers);

        UserGroup centraAdministrators = new UserGroup();
        centraAdministrators.setName(UserGroup.CENTRA_ADMINISTRATORS);
        userService.saveGroup(centraAdministrators);
    }
}