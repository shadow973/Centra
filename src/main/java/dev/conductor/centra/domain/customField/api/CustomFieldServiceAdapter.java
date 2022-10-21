package dev.conductor.centra.domain.customField.api;

import dev.conductor.centra.domain.customField.entity.CustomField;
import dev.conductor.centra.domain.customField.entity.CustomFieldValue;
import dev.conductor.centra.domain.customField.spi.CustomFieldPersistencePort;
import dev.conductor.centra.domain.customField.spi.CustomFieldValuePersistencePort;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.project.spi.ProjectPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomFieldServiceAdapter implements CustomFieldService {

    private final CustomFieldPersistencePort customFieldPersistencePort;
    private final CustomFieldValuePersistencePort customFieldValuePersistencePort;
    private final ProjectPersistencePort projectPersistencePort;

    @Autowired
    public CustomFieldServiceAdapter(CustomFieldPersistencePort customFieldPersistencePort, CustomFieldValuePersistencePort customFieldValuePersistencePort, ProjectPersistencePort projectPersistencePort) {
        this.customFieldPersistencePort = customFieldPersistencePort;
        this.customFieldValuePersistencePort = customFieldValuePersistencePort;
        this.projectPersistencePort = projectPersistencePort;
    }

    @Override
    public CustomField getCustomFieldById(String id) {
        return customFieldPersistencePort.findById(id);
    }

    @Override
    public CustomField createCustomField(CustomField customField) {
        return customFieldPersistencePort.save(customField);
    }

    @Override
    public List<CustomFieldValue> getCustomFieldValuesForIssue(Issue issue) {
        return customFieldValuePersistencePort.findByIssue(issue);
    }

    @Override
    public CustomFieldValue saveValue(Issue issue, CustomFieldValue customFieldValue) {
        customFieldValue.setIssueId(issue.getId());
        return customFieldValuePersistencePort.save(customFieldValue);
    }

    @Override
    public List<CustomFieldValue> createDefaultCustomFieldValuesForIssue(Issue issue) {
        List<CustomField> projectFields = customFieldPersistencePort.findByProject(
                projectPersistencePort.findById(issue.getProjectId())
        );

        List<CustomFieldValue> results = new ArrayList<>();
        projectFields.forEach(customField -> {
            CustomFieldValue customFieldValue = new CustomFieldValue();
            customFieldValue.setCustomFieldId(customField.getId());
            customFieldValue.setStringValue(customField.getDefaultValue().toString());
            results.add(this.saveValue(issue, customFieldValue));
        });

        return results;
    }   
}
