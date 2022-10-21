package dev.conductor.centra.domain.issue.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class IssueType implements Serializable {

    private String id;
    private String label;
    private String icon;

    public IssueType(){}

    public IssueType(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }
}
