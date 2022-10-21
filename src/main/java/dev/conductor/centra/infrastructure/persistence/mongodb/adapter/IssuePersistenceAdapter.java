package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.issue.spi.IssuePersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssuePersistenceAdapter implements IssuePersistencePort {

    private final ModelMapper modelMapper;
    private final IssueRepository repository;

    @Autowired
    public IssuePersistenceAdapter(ModelMapper modelMapper, IssueRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<Issue> findByProjectId(String projectId) {
        List<Issue> issueList = new ArrayList<>();

        for (IssueEntity issueEntity : repository.findByProjectId(projectId)) {
            issueList.add(modelMapper.map(issueEntity, Issue.class));
        }

        return issueList;
    }

    @Override
    public Issue findByProjectIdAndExternalId(String projectId, long externalId) {
        return modelMapper.map(repository.findByProjectIdAndExternalId(projectId, externalId), Issue.class);
    }

    @Override
    @CachePut(value = "issues", key = "#issue.id", condition="#issue.id != null")
    public Issue save(Issue issue) {
        return modelMapper.map(repository.save(modelMapper.map(issue, IssueEntity.class)), Issue.class);
    }

    @Override
    @CacheEvict(value = "issues", key = "#issue.id")
    public void delete(Issue issue) {
        repository.delete(modelMapper.map(issue, IssueEntity.class));
    }
}
