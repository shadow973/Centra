package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "issue_comments")
public class IssueCommentEntity {

    @Id private String id;
    private String issueId;
    private String text;
    private Date createdDate;
    private String createdByUserId;
}
