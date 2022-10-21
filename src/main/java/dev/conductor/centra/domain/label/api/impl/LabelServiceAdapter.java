package dev.conductor.centra.domain.label.api.impl;

import dev.conductor.centra.domain.label.api.LabelService;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceAdapter implements LabelService {

    @Autowired
    LabelRepository repository;

    @Override
    public List<String> findAll() {
        return repository.findAll();
    }
}
