package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.IssueType;
import dev.conductor.centra.domain.issue.spi.IssueTypePersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueTypeEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssueTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Repository
public class IssueTypePersistenceAdapter implements IssueTypePersistencePort {

    private final IssueTypeRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueTypePersistenceAdapter(IssueTypeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueType findByLabel(String label) {
        return modelMapper.map(repository.findByLabel(label), IssueType.class);
    }

    @Override
    public IssueType findById(String id) {
        return repository.findById(id).map(
                    issueTypeEntity -> modelMapper.map(issueTypeEntity, IssueType.class)
                ).orElse(null);
    }

    @Override
    public List<IssueType> findAll() {
        return repository.findAll().stream().map(
                    issueTypeEntity -> modelMapper.map(issueTypeEntity, IssueType.class)
                ).toList();
    }

    @Override
    @CachePut(value = "issueType", key = "#issueType.id", condition="#issueType.id != null")
    public IssueType create(IssueType issueType) {
        return modelMapper.map(repository.save(modelMapper.map(issueType, IssueTypeEntity.class)), IssueType.class);
    }
}
