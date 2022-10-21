package dev.conductor.centra.domain.customField.dto;

import dev.conductor.centra.domain.customField.entity.CustomField;
import dev.conductor.centra.domain.customField.entity.CustomFieldValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomFieldValueWithCustomFieldDTO {

    private final CustomField customField;
    private final CustomFieldValue customFieldValue;

    public CustomFieldValueWithCustomFieldDTO(CustomField customField, CustomFieldValue customFieldValue) {
        this.customField = customField;
        this.customFieldValue = customFieldValue;
    }
}
