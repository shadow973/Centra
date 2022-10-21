package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "issue_type_schemas")
public class IssueTypeSchemaEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<String> issueTypeIds;

    public IssueTypeSchemaEntity(){}

    public IssueTypeSchemaEntity(String name){
        this.name = name;
        this.issueTypeIds = new ArrayList<>();
    }

    public void addIssueType(IssueTypeEntity issueType) {
        this.issueTypeIds.add(issueType.getId());
    }
}
