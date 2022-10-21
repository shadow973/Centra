package dev.conductor.centra.domain.customField.spi;

import dev.conductor.centra.domain.customField.entity.CustomField;
import dev.conductor.centra.domain.project.entity.Project;

import java.util.List;

public interface CustomFieldPersistencePort {

    CustomField save(CustomField customField);
    CustomField findByName(String name);
    List<CustomField> findByProject(Project project);
    CustomField findById(String id);
}
