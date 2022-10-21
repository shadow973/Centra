package dev.conductor.centra.domain.customField.api;

import dev.conductor.centra.domain.customField.entity.CustomField;
import dev.conductor.centra.domain.customField.entity.CustomFieldValue;
import dev.conductor.centra.domain.issue.entity.Issue;

import java.util.List;

public interface CustomFieldService {
    CustomField getCustomFieldById(String id);
    CustomField createCustomField(CustomField customField);
    List<CustomFieldValue> getCustomFieldValuesForIssue(Issue issue);
    CustomFieldValue saveValue(Issue issue, CustomFieldValue customFieldValue);
    List<CustomFieldValue> createDefaultCustomFieldValuesForIssue(Issue issue);
}
