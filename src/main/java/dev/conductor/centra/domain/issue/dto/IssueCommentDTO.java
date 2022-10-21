package dev.conductor.centra.domain.issue.dto;

import java.util.Date;

public class IssueCommentDTO {

    private final String id;
    private final String issueId;
    private final String text;
    private final Date createdDate;

    public IssueCommentDTO(String id, String issueId, String text, Date createdDate) {
        this.id = id;
        this.issueId = issueId;
        this.text = text;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public String getIssueId() {
        return issueId;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
