package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.customField.entity.CustomField;
import dev.conductor.centra.domain.customField.spi.CustomFieldPersistencePort;
import dev.conductor.centra.domain.project.entity.Project;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.CustomFieldEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.CustomFieldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomFieldPersistenceAdapter implements CustomFieldPersistencePort {

    private final ModelMapper modelMapper;
    private final CustomFieldRepository customFieldRepository;

    @Autowired
    public CustomFieldPersistenceAdapter(ModelMapper modelMapper, CustomFieldRepository customFieldRepository) {
        this.modelMapper = modelMapper;
        this.customFieldRepository = customFieldRepository;
    }

    @Override
    public CustomField save(CustomField customField) {
        CustomFieldEntity entity = modelMapper.map(customField, CustomFieldEntity.class);
        customFieldRepository.save(entity);

        return modelMapper.map(entity, CustomField.class);
    }

    @Override
    public CustomField findByName(String name) {
        CustomFieldEntity entity = customFieldRepository.findByName(name);
        return modelMapper.map(entity, CustomField.class);
    }

    @Override
    public List<CustomField> findByProject(Project project) {
        return customFieldRepository.findByProjectId(project.getId()
        )
                .stream()
                .map(customFieldEntity -> modelMapper.map(customFieldEntity, CustomField.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomField findById(String id) {
        return customFieldRepository.findById(id)
                .map(customFieldEntity -> modelMapper.map(customFieldEntity, CustomField.class))
                .orElse(null);
    }
}
