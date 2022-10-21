package dev.conductor.centra.domain.issue.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IssuePrioritySchema implements Serializable {

    private String id;
    private String name;
    private List<String> priorityIds = new ArrayList<>();

    public void addPriority(IssuePriority priority) {
        this.priorityIds.add(priority.getId());
    }
}
