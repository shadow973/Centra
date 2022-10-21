package dev.conductor.centra.data.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.settings.SettingsEnum;
import dev.conductor.centra.data.install.DefaultInstall;
import dev.conductor.centra.domain.issue.api.IssuePrioritySchemaService;
import dev.conductor.centra.domain.issue.api.IssueTypeSchemaService;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.settings.api.SettingsService;
import dev.conductor.centra.domain.settings.entity.Settings;
import dev.conductor.centra.domain.workflow.api.WorkflowService;
import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;

@ChangeLog(order = "001")
@Slf4j
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "databaseInitialisation", author = "CSF")
    public void databaseInitialisation(
            SettingsService settingsService,
            IssueTypeSchemaService issueTypeSchemaService,
            WorkflowService workflowService,
            ProjectService projectService,
            IssuePrioritySchemaService prioritySchemaService,
            ApplicationUserService userService
    ) {
        updateSettings(settingsService);
        DefaultInstall install = new DefaultInstall(
                issueTypeSchemaService,
                workflowService,
                projectService,
                prioritySchemaService,
                userService
        );

        install.createDefaultEntities();
    }

    private void updateSettings(SettingsService settingsService) {
        for (SettingsEnum settings: EnumSet.allOf(SettingsEnum.class)) {
            Settings retrievedValue = settingsService.getSettingsByName(settings);

            if (retrievedValue == null){
                log.info("Setting up default settings for " + settings.name());
                Settings entity = new Settings(
                        settings.name(),
                        settingsService.getDefaultByName(settings).getValue()
                );

                settingsService.save(entity);
            }
        }
    }
}
