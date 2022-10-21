package dev.conductor.centra.domain.issue.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class IssueComment implements Serializable {

    private String id;
    private String issueId;
    private String text;
    private Date createdDate;
    private String createdByUserId;
}
