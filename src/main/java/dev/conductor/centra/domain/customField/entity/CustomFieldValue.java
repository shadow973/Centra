package dev.conductor.centra.domain.customField.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomFieldValue {

    private String id;
    private String issueId;
    private String customFieldId;
    private String stringValue;
}
