package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.IssueLinks;
import dev.conductor.centra.domain.issue.spi.IssueLinksPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueLinksEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.IssueLinksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IssueLinksPersistenceAdapter implements IssueLinksPersistencePort {

    private final IssueLinksRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueLinksPersistenceAdapter(IssueLinksRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<IssueLinks> findByNodePublicId(String id) {
        return repository.findByNodePublicId(id).stream().map(
                issueLinksEntity -> modelMapper.map(issueLinksEntity, IssueLinks.class)
        ).collect(Collectors.toList());
    }

    @Override
    public List<IssueLinks> findByLinkPublicId(String id) {
        return repository.findByLinkPublicId(id).stream().map(
                issueLinksEntity -> modelMapper.map(issueLinksEntity, IssueLinks.class)
        ).collect(Collectors.toList());
    }

    @Override
    public IssueLinks findById(String id) {
        return repository.findById(id).map(issueLinksEntity ->
                modelMapper.map(issueLinksEntity, IssueLinks.class)
            ).orElse(null);
    }

    @Override
    public void delete(IssueLinks issueLinks) {
        repository.delete(modelMapper.map(issueLinks, IssueLinksEntity.class));
    }

    @Override
    public IssueLinks create(IssueLinks issueLinks) {
        return modelMapper.map(repository.save(modelMapper.map(issueLinks, IssueLinksEntity.class)), IssueLinks.class);
    }
}
