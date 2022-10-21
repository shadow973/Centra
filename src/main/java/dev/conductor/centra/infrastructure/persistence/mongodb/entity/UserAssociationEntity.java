package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@CompoundIndexes({
        @CompoundIndex(name = "userAssociation_type_sinkentity_sourceId", def = "{'associationType' : 1, 'sinkNodeEntity': 1}, 'sourceId' : 1")
})
public class UserAssociationEntity {
    @Id private String id;
    @Indexed
    private String associationType;
    @Indexed
    private String sinkNodeEntity;
    @Indexed
    private String sourceId;
    private String sinkId;
}
