package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.customField.entity.CustomFieldValue;
import dev.conductor.centra.domain.customField.spi.CustomFieldValuePersistencePort;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.infrastructure.persistence.mongodb.adapter.exceptions.DuplicateCustomFieldValue;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.CustomFieldValueEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.CustomFieldValueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomFieldValuePersistenceAdapter implements CustomFieldValuePersistencePort {

    private final ModelMapper modelMapper;
    private final CustomFieldValueRepository repository;

    @Autowired
    public CustomFieldValuePersistenceAdapter(ModelMapper modelMapper, CustomFieldValueRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public CustomFieldValue save(CustomFieldValue customFieldValue) {
        CustomFieldValueEntity entity = modelMapper.map(customFieldValue, CustomFieldValueEntity.class);
        try {
            repository.save(entity);
        } catch (DuplicateKeyException e) {
            throw new DuplicateCustomFieldValue("Duplicate Custom Field Value: issue id + custom field value id");
        }

        return modelMapper.map(entity, CustomFieldValue.class);
    }

    @Override
    public List<CustomFieldValue> findByIssue(Issue issue) {
        return repository.findByIssueId(issue.getId())
                .stream()
                .map(customFieldEntity -> modelMapper.map(customFieldEntity, CustomFieldValue.class))
                .collect(Collectors.toList());
    }
}
