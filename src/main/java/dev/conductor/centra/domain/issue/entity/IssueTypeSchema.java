package dev.conductor.centra.domain.issue.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IssueTypeSchema implements Serializable {

    private String id;
    private String name;
    private List<String> issueTypeIds;

    public IssueTypeSchema(){}

    public IssueTypeSchema(String name){
        this.name = name;
        this.issueTypeIds = new ArrayList<>();
    }

    public void addIssueType(IssueType issueType) {
        this.issueTypeIds.add(issueType.getId());
    }
}
