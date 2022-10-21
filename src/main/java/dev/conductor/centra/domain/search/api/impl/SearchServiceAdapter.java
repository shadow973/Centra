package dev.conductor.centra.domain.search.api.impl;

import dev.conductor.centra.domain.search.api.SearchService;
import dev.conductor.centra.domain.search.cql.conditions.Assignee;
import dev.conductor.centra.domain.search.cql.conditions.Condition;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.domain.applicationUser.api.ApplicationUserService;
import dev.conductor.centra.domain.project.api.ProjectService;
import dev.conductor.centra.domain.search.cql.conditions.ProjectKeys;
import dev.conductor.centra.domain.search.cql.conditions.Reporter;
import dev.conductor.centra.domain.search.spi.SearchPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchServiceAdapter implements SearchService {

    private final ProjectService projectService;
    private final ApplicationUserService applicationUserService;
    private final SearchPersistencePort persistencePort;

    @Autowired
    public SearchServiceAdapter(
            ProjectService projectService,
            ApplicationUserService applicationUserService,
            SearchPersistencePort persistencePort
    ) {
        this.projectService = projectService;
        this.applicationUserService = applicationUserService;
        this.persistencePort = persistencePort;
    }

    @Override
    public List<Issue> search(List<Condition> conditions) {

        List<Condition> conditionsEnriched = conditions
                .stream()
                .map(this::enrichCondition)
                .toList();

        return persistencePort.find(conditionsEnriched);
    }

    private Condition enrichCondition(Condition condition) {

        if (condition instanceof ProjectKeys) {
            List<Project> projects = condition.getValue()
                    .stream()
                    .map(key -> projectService.findByKey(key.toUpperCase()))
                    .filter(Objects::nonNull)
                    .toList();

            List<String> projectIds = projects.stream().map(Project::getId).toList();

            ProjectKeys criteria = new ProjectKeys();
            criteria.setValue(projectIds);
            criteria.setOperator(condition.getOperator());

            return criteria;
        }

        if (condition instanceof Assignee) {
            List<String> users = condition.getValue()
                    .stream()
                    .map(applicationUserService::findByUsername)
                    .map(k -> k == null ? null : k.getId())
                    .collect(Collectors.toList());

            Assignee criteria = new Assignee();
            criteria.setOperator(condition.getOperator());
            criteria.setValue(users);

            return criteria;
        }

        if (condition instanceof Reporter) {
            List<String> users = condition.getValue()
                    .stream()
                    .map(applicationUserService::findByUsername)
                    .map(k -> k == null ? null : k.getId())
                    .collect(Collectors.toList());

            Reporter criteria = new Reporter();
            criteria.setOperator(condition.getOperator());
            criteria.setValue(users);

            return criteria;
        }

        return condition;
    }

}
