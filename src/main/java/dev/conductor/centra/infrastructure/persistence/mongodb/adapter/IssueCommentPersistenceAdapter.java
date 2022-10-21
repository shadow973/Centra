package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.IssueComment;
import dev.conductor.centra.domain.issue.spi.IssueCommentPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueCommentEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssueCommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueCommentPersistenceAdapter implements IssueCommentPersistencePort {

    private final IssueCommentRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueCommentPersistenceAdapter(IssueCommentRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<IssueComment> findByIssueIdOrderByCreatedDateAsc(String id) {
        List<IssueComment> results = new ArrayList<>();

        for (IssueCommentEntity entity : repository.findByIssueIdOrderByCreatedDateAsc(id)) {
            results.add(modelMapper.map(entity, IssueComment.class));
        }

        return results;
    }

    @Override
    public IssueComment save(IssueComment comment) {
        return modelMapper.map(repository.save(modelMapper.map(comment, IssueCommentEntity.class)), IssueComment.class);
    }
}
