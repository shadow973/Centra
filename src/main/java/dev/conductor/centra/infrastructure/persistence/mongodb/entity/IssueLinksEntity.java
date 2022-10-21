package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "issue_links")
public class IssueLinksEntity {

    @Id
    private String id;

    @Indexed
    private String nodePublicId;

    @Indexed
    private String linkPublicId;
}
