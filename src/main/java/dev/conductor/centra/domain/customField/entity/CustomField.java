package dev.conductor.centra.domain.customField.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomField {

    private String id;
    private String name;
    private Object defaultValue;
    private String valueType;
    private String projectId;
    private List<String> options = new ArrayList<>();
}
