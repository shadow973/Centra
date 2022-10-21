package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "custom_field_values")
@CompoundIndexes({
        @CompoundIndex(name="custom_field_values_issue_customfieldid", def = "{'issueId' : 1, 'customFieldId' : 1}" ,unique = true)
})
public class CustomFieldValueEntity {

    @Id private String id;
    private String issueId;
    private String customFieldId;
    private String stringValue;
}
