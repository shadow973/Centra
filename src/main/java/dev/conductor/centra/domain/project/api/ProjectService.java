package dev.conductor.centra.domain.project.api;


import dev.conductor.centra.domain.project.entity.Project;

import java.util.List;

public interface ProjectService {

    Project findByKey(String key);
    Project findByName(String name);
    Project findById(String id);
    Project create(Project project);
    List<Project> listAll();
    void delete(Project project);
    Project save(Project project);
}
