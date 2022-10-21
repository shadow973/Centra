package dev.conductor.centra.domain.project.spi;

import dev.conductor.centra.domain.project.entity.Project;

import java.util.List;

public interface ProjectPersistencePort {

    Project findByProjectKey(String key);
    Project findByProjectName(String name);
    Project findById(String id);
    Project save(Project project);
    List<Project> findAll();
    void delete(Project project);
}
