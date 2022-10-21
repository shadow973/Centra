package dev.conductor.centra.domain.issue.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IssueLinks implements Serializable {

    private String id;
    private String nodePublicId;
    private String linkPublicId;
}
