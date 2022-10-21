package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.IssuePriority;
import dev.conductor.centra.domain.issue.spi.IssuePriorityPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssuePriorityEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssuePriorityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssuePriorityPersistenceAdapter implements IssuePriorityPersistencePort {

    private final IssuePriorityRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssuePriorityPersistenceAdapter(IssuePriorityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<IssuePriority> findAll() {
        return repository.findAll().stream().map(
                    issuePriorityEntity -> modelMapper.map(issuePriorityEntity, IssuePriority.class)
                ).toList();
    }

    @Override
    public IssuePriority findByLabel(String label) {
        return modelMapper.map(repository.findByLabel(label), IssuePriority.class);
    }

    @Override
    public IssuePriority findById(String id) {
        return repository.findById(id).map(
                    issuePriorityEntity -> modelMapper.map(issuePriorityEntity, IssuePriority.class)
                ).orElse(null);
    }

    @Override
    @CachePut(value = "issuePriority", key = "#issuePriority.id", condition="#issuePriority.id != null")
    public IssuePriority create(IssuePriority issuePriority) {
        return modelMapper.map(
                repository.save(
                        modelMapper.map(issuePriority, IssuePriorityEntity.class)
                ), IssuePriority.class);
    }
}
