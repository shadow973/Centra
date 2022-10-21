package dev.conductor.centra.domain.issue.dto;

import java.time.LocalDateTime;

public class IssueChangeDTO {

    private final String changeByUserId;
    private final LocalDateTime changeDate;
    private final String propertyNameWithPath;
    private final Object right;
    private final Object left;

    public IssueChangeDTO(String changeByUserId, LocalDateTime changeDate, String propertyNameWithPath, Object right, Object left) {
        this.changeByUserId = changeByUserId;
        this.changeDate = changeDate;
        this.propertyNameWithPath = propertyNameWithPath;
        this.right = right;
        this.left = left;
    }

    public String getChangeByUserId() {
        return changeByUserId;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public String getPropertyNameWithPath() {
        return propertyNameWithPath;
    }

    public Object getRight() {
        return right;
    }

    public Object getLeft() {
        return left;
    }
}
