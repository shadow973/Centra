package dev.conductor.centra.domain.issue.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IssuePriority implements Serializable {
    private String id;
    private String label;
    private String icon;

    public IssuePriority() {}

    public IssuePriority(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }
}
