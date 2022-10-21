package dev.conductor.centra.domain.userAssociation.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserAssociation implements Serializable {
    private String id;
    private String associationType;
    private String sinkNodeEntity;
    private String sourceId;
    private String sinkId;
}
