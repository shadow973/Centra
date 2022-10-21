package dev.conductor.centra.domain.customField.spi;

import dev.conductor.centra.domain.customField.entity.CustomFieldValue;
import dev.conductor.centra.domain.issue.entity.Issue;

import java.util.List;

public interface CustomFieldValuePersistencePort {
    CustomFieldValue save(CustomFieldValue value);
    List<CustomFieldValue> findByIssue(Issue issue);
}
