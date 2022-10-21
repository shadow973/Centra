package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "issue_priority_schemas")
public class IssuePrioritySchemaEntity {

    private String id;
    @Indexed(unique = true)
    private String name;
    private List<String> priorityIds = new ArrayList<>();

    public void addPriority(IssuePriorityEntity priority) {
        this.priorityIds.add(priority.getId());
    }
}
