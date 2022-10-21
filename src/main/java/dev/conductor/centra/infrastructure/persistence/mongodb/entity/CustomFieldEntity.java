package dev.conductor.centra.infrastructure.persistence.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "custom_fields")
public class CustomFieldEntity {

    @Id private String id;
    @Indexed(unique=true)
    private String name;
    private Object defaultValue;
    private String valueType;
    private String projectId;
    private List<String> options = new ArrayList<>();
}
