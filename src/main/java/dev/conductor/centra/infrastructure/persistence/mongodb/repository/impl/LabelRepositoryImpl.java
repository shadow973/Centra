package dev.conductor.centra.infrastructure.persistence.mongodb.repository.impl;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LabelRepositoryImpl implements LabelRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<String> findAll() {
        return mongoTemplate.query(IssueEntity.class).distinct("labels").all()
                .stream()
                .filter(val -> val instanceof String)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
